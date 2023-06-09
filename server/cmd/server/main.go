package main

import (
	"fmt"
	"server/config"
	mqtt2 "server/pkg/mqtt"
	"server/pkg/scylla"
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

	fmt.Println(mqttClient)
	fmt.Println(session)

}
