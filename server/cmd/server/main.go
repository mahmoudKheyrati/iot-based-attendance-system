package main

import (
	"fmt"
	"github.com/eclipse/paho.mqtt.golang"
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
	var topicNames = c.TopicNames
	mqttClient.Subscribe(topicNames.Request, mqtt2.ExactlyOnce, func(client mqtt.Client, message mqtt.Message) {

	})
	mqttClient.Subscribe(topicNames.LockOpened, mqtt2.ExactlyOnce, func(client mqtt.Client, message mqtt.Message) {

	})
	mqttClient.Subscribe(topicNames.AdminCommandResponse, mqtt2.ExactlyOnce, func(client mqtt.Client, message mqtt.Message) {

	})

	mqttClient.Subscribe(topicNames.LockState, mqtt2.ExactlyOnce, func(client mqtt.Client, message mqtt.Message) {

	})

	//mqttClient.Publish(topicNames.AdminCommand, mqtt2.ExactlyOnce, false, "")
	//mqttClient.Publish(fmt.Sprintf("%s-%s", topicNames.Response, "USER_ID"), mqtt2.ExactlyOnce, false, "")

	fmt.Println(mqttClient)
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
