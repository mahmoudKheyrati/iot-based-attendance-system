package mqtt_handlers

import (
	"fmt"
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"strconv"
	"strings"
)

func DeviceStateHandler() func(client mqtt.Client, message mqtt.Message) {
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
		rgbString := strings.TrimPrefix(payloadParts[1], "LED_COLOR_")
		red, err := strconv.Atoi(fmt.Sprintf("%c", rgbString[0]))
		if err != nil {
			// log the error using zap
			return
		}
		green, err := strconv.Atoi(fmt.Sprintf("%c", rgbString[1]))
		if err != nil {
			// log the error using zap
			return
		}
		blue, err := strconv.Atoi(fmt.Sprintf("%c", rgbString[2]))
		if err != nil {
			// log the error using zap
			return
		}

		fmt.Println("device-state deviceId:", deviceId, " secondsAfterStart:", secondAfterStart, " red:", red, " green:", green, " blue:", blue)

	}
}
