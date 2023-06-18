package main

import (
	"fmt"
	"google.golang.org/grpc"
	"net"
	"server/internal/mqtt_handlers"
	"server/pkg/db"
	"server/proto/gen/pb-go/iot/attendance_system"

	"log"
	"os"
	"os/signal"
	"server/config"
	mqtt2 "server/pkg/mqtt"
	"server/pkg/scylla"

	"google.golang.org/grpc/reflection"
)

func main() {
	// todo: add logger

	c := config.NewConfig()

	mqttSubscriberClient, err := mqtt2.NewMqttClient(mqtt2.Config{
		Host:           c.MqttBrokerConfig.Host,
		Port:           c.MqttBrokerConfig.Port,
		ClientId:       c.MqttBrokerConfig.ClientId + "-subscriber",
		Username:       c.MqttBrokerConfig.Username,
		Password:       c.MqttBrokerConfig.Password,
		KeepAliveSec:   c.MqttBrokerConfig.KeepAliveSec,
		PingTimeoutSec: c.MqttBrokerConfig.PingTimeoutSec,
	})
	if err != nil {
		panic(err)
	}

	mqttPublisherClient, err := mqtt2.NewMqttClient(mqtt2.Config{
		Host:           c.MqttBrokerConfig.Host,
		Port:           c.MqttBrokerConfig.Port,
		ClientId:       c.MqttBrokerConfig.ClientId + "-publisher",
		Username:       c.MqttBrokerConfig.Username,
		Password:       c.MqttBrokerConfig.Password,
		KeepAliveSec:   c.MqttBrokerConfig.KeepAliveSec,
		PingTimeoutSec: c.MqttBrokerConfig.PingTimeoutSec,
	})
	if err != nil {
		panic(err)
	}

	session, err := scylla.NewScyllaSession(scylla.Config{
		Host:            c.ScyllaConfig.Host,
		Port:            c.ScyllaConfig.Port,
		Username:        c.ScyllaConfig.Username,
		Password:        c.ScyllaConfig.Password,
		DefaultKeyspace: c.ScyllaConfig.DefaultKeyspace,
	})
	if err != nil {
		panic(err)
	}

	//adminCommandLogRepo := db.NewAdminCommandLogRepo(session)
	//attendanceLogRepo := db.NewAttendanceLogRepo(session)
	//deviceRepo := db.NewDeviceRepo(session)
	deviceStartupRepo := db.NewDeviceStartupRepo(session)
	deviceStateLogRepo := db.NewDeviceStateLogRepo(session)
	employeeRepo := db.NewEmployeeRepo(session)
	lockOpenedLogRepo := db.NewLockOpenedLogRepo(session)

	var tn = c.TopicNames
	mqttSubscriberClient.Subscribe(fmt.Sprintf("%s/+", tn.DeviceStartup), mqtt2.ExactlyOnce, mqtt_handlers.DeviceStartupHandler(deviceStartupRepo))
	mqttSubscriberClient.Subscribe(fmt.Sprintf("%s/+", tn.Request), mqtt2.ExactlyOnce, mqtt_handlers.RequestHandler(mqttPublisherClient, employeeRepo))
	mqttSubscriberClient.Subscribe(fmt.Sprintf("%s/+", tn.LockOpened), mqtt2.ExactlyOnce, mqtt_handlers.LockOpenedHandler(lockOpenedLogRepo))
	mqttSubscriberClient.Subscribe(fmt.Sprintf("%s/+", tn.DeviceState), mqtt2.ExactlyOnce, mqtt_handlers.DeviceStateHandler(deviceStateLogRepo))

	log.Println("starting grpc server on port: ", c.Port)
	listen, err := net.Listen("tcp", fmt.Sprintf(":%d", c.Port))
	if err != nil {
		log.Fatalln(err)
	}
	server := grpc.NewServer()
	reflection.Register(server)
	attendance_system.RegisterAttendanceSystemServer(server, nil)
	if err := server.Serve(listen); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}

	quit := make(chan os.Signal, 1)
	signal.Notify(quit, os.Interrupt)
	<-quit
	fmt.Println("gracefully shutdown ...")

	log.Println("disconnecting mqtt ...")
	mqttSubscriberClient.Disconnect(250)

	log.Println("closing scylla session ...")
	session.Close()

	log.Println("graceful stop grpc server ...")
	server.GracefulStop()

}
