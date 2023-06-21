package mqtt_handlers

import (
	"fmt"
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"log"
	"server/pkg/db"
	mqtt2 "server/pkg/mqtt"
	"strconv"
	"strings"
	"time"
)

func RequestHandler(mqttClient mqtt.Client, repo *db.EmployeeRepo) func(client mqtt.Client, message mqtt.Message) {
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

		log.Println("request device_id:", deviceId, " secondAfterStart:", secondAfterStart, " cardUid:", cardUid)

		employee, err := repo.GetByCardUID(cardUid)
		if err != nil || employee == nil {
			log.Println(err)
			return
		}
		var isPermitted bool
		for _, rule := range employee.Rules {
			if rule == deviceId {
				isPermitted = true
				break
			}
		}
		var lockPermitted = "LOCK_OPEN_NOT_PERMITTED"
		lcdMessage := fmt.Sprintf("not permitted\n\n%s %s !", employee.FirstName, employee.LastName)

		if isPermitted {
			lockPermitted = "LOCK_OPEN_PERMITTED"
			lcdMessage = fmt.Sprintf("welcome\n\n%s\n\n%s ;)", employee.FirstName, employee.LastName)

		}

		messagePayload := fmt.Sprintf("%d,%s,%s", time.Now().Unix(), lockPermitted, lcdMessage)
		mqttClient.Publish(fmt.Sprintf("response/%s/%s", deviceId, cardUid), mqtt2.ExactlyOnce, false, messagePayload)
	}
}
