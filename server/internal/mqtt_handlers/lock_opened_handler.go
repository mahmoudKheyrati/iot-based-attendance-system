package mqtt_handlers

import (
	"fmt"
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"strconv"
	"strings"
)

func LockOpenedHandler() func(client mqtt.Client, message mqtt.Message) {
	return func(client mqtt.Client, message mqtt.Message) {
		topic := message.Topic()
		topicParts := strings.Split(topic, "/")
		deviceId := topicParts[1]

		payload := string(message.Payload())
		payloadParts := strings.Split(payload, ",")
		secondAfterStart, err := strconv.Atoi(payloadParts[0])
		if err != nil {
			// log the error using zap
			return
		}

		fmt.Println("lock-opened deviceId:", deviceId, " secondAfterStart:", secondAfterStart)

	}
}
