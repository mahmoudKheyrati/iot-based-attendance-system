package mqtt_handlers

import (
	"fmt"
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"strings"
	"time"
)

func DeviceStartupHandler() func(client mqtt.Client, message mqtt.Message) {
	return func(client mqtt.Client, message mqtt.Message) {
		topic := message.Topic()
		topicParts := strings.Split(topic, "/")
		deviceId := topicParts[1]
		timestamp := time.Now().Unix()
		fmt.Println("device_startup deviceId:", deviceId, " at timestamp:", timestamp)

	}
}
