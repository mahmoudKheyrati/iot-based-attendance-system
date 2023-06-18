package mqtt_handlers

import (
	"fmt"
	mqtt "github.com/eclipse/paho.mqtt.golang"
	mqtt2 "server/pkg/mqtt"
	"strconv"
	"strings"
	"time"
)

func RequestHandler(mqttClient mqtt.Client) func(client mqtt.Client, message mqtt.Message) {
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
		cardUid := payloadParts[1]

		fmt.Println("request device_id:", deviceId, " secondAfterStart:", secondAfterStart, " cardUid:", cardUid)

		// check authorization and then send response
		//lockPermitted: LOCK_OPEN_PERMITED, LOCK_OPEN_NOT_PERMITED
		var isPermitted = true
		lockPermitted := "LOCK_OPEN_NOT_PERMITTED"
		if isPermitted {
			lockPermitted = "LOCK_OPEN_PERMITTED"
		}
		lcdMessage := "your welcome mahmoud ;)"

		messagePayload := fmt.Sprintf("%d,%s,%s", time.Now().Unix(), lockPermitted, lcdMessage)
		mqttClient.Publish(fmt.Sprintf("response/%s/%s", deviceId, cardUid), mqtt2.ExactlyOnce, false, messagePayload)
	}
}
