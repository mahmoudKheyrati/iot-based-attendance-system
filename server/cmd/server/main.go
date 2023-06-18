package main

import (
	"fmt"
	"github.com/gofiber/fiber/v2"
	"github.com/gofiber/fiber/v2/middleware/recover"
	"google.golang.org/grpc"
	"net"
	"server/internal/mqtt_handlers"
	"server/proto/gen/pb-go/iot/attendance_system"

	"log"
	"os"
	"os/signal"
	"server/config"
	mqtt2 "server/pkg/mqtt"
	"server/pkg/scylla"
	"time"
)

func main() {
	c := config.NewConfig()

	mqttClient, err := mqtt2.NewMqttClient(mqtt2.Config{
		Host:           c.MqttBrokerConfig.Host,
		Port:           c.MqttBrokerConfig.Port,
		ClientId:       c.MqttBrokerConfig.ClientId,
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
	//deviceStartupRepo := db.NewDeviceStartupRepo(session)
	//deviceStateLogRepo := db.NewDeviceStateLogRepo(session)
	//employeeRepo := db.NewEmployeeRepo(session)
	//lockOpenedLogRepo := db.NewLockOpenedLogRepo(session)

	var tn = c.TopicNames
	mqttClient.Subscribe(fmt.Sprintf("%s/+", tn.DeviceStartup), mqtt2.ExactlyOnce, mqtt_handlers.DeviceStartupHandler())
	mqttClient.Subscribe(fmt.Sprintf("%s/+", tn.Request), mqtt2.ExactlyOnce, mqtt_handlers.RequestHandler(mqttClient))
	mqttClient.Subscribe(fmt.Sprintf("%s/+", tn.LockOpened), mqtt2.ExactlyOnce, mqtt_handlers.LockOpenedHandler())
	mqttClient.Subscribe(fmt.Sprintf("%s/+", tn.DeviceState), mqtt2.ExactlyOnce, mqtt_handlers.DeviceStateHandler())

	listen, err := net.Listen("tcp", fmt.Sprintf(":%d", c.Port))
	if err != nil {
		log.Fatalln(err)
	}
	server := grpc.NewServer()
	attendance_system.RegisterAttendanceSystemServer(server, nil)
	if err := server.Serve(listen); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}

	app := fiber.New()
	app.Use(recover.New())

	api := app.Group("/api")
	v1 := api.Group("/v1")

	// todo: add authentication middleware

	v1.Post("/admin-command", func(c *fiber.Ctx) error {
		body := struct {
			DeviceId string
			Command  string
			R        int
			G        int
			B        int
		}{}
		if err := c.BodyParser(&body); err != nil {
			// log error
			return nil
		}
		switch body.Command {
		case "open-door":
			payloadOpenDoor := fmt.Sprintf("%d,%s", time.Now().Unix(), "LOCK_OPEN_PERMITTED")
			mqttClient.Publish(fmt.Sprintf("%s/%s", tn.AdminCommand, body.DeviceId), mqtt2.ExactlyOnce, false, payloadOpenDoor)

		case "change-led-color":
			payloadLedChangeColor := fmt.Sprintf("%d,LED_CHANGE_COLOR_%d%d%d", time.Now().Unix(), body.R, body.G, body.B)
			mqttClient.Publish(fmt.Sprintf("%s/%s", tn.AdminCommand, body.DeviceId), mqtt2.ExactlyOnce, false, payloadLedChangeColor)

		default:

			return c.Status(400).JSONP(fiber.Map{"status": "error", "message": "command not supported"})
		}

		return c.Status(200).JSONP(fiber.Map{"status": "ok", "message": "admin command send to iot device successfully"})
	})

	go func() {
		err = app.Listen(fmt.Sprintf(":%d", c.Port))
		if err != nil {
			log.Println(err)
		}
	}()

	// todo: add websocket to show led colors real-time and lock-opened history

	fmt.Println(session)

	quit := make(chan os.Signal, 1)
	signal.Notify(quit, os.Interrupt)
	<-quit
	fmt.Println("gracefully shutdown ...")
	//ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	//defer cancel()
	mqttClient.Disconnect(250)
	session.Close()
	time.Sleep(3 * time.Second)
	//if err := srv.Shutdown(ctx); err != nil {
	//	log.Fatal(err)
	//}

}
