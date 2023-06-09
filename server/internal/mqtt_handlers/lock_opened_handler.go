package mqtt_handlers

import (
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"log"
	"server/pkg/db"
	"strconv"
	"strings"
	"time"
)

func LockOpenedHandler(repo *db.LockOpenedLogRepo) func(client mqtt.Client, message mqtt.Message) {
	return func(client mqtt.Client, message mqtt.Message) {
		topic := message.Topic()
		topicParts := strings.Split(topic, "/")
		deviceId := topicParts[1]

		payload := string(message.Payload())
		payloadParts := strings.Split(payload, ",")
		cardUid := payloadParts[0]
		secondAfterStart, err := strconv.Atoi(payloadParts[1])
		if err != nil {
			// log the error using zap
			return
		}

		log.Println("lock-opened deviceId:", deviceId, " secondAfterStart:", secondAfterStart)
		err = repo.Insert(db.LockOpenedLog{
			DeviceID:            deviceId,
			CardUid:             cardUid,
			ServerTimestamp:     time.Now(),
			TimeAfterStartupSec: secondAfterStart,
		})
		if err != nil {
			log.Println(err)
			return
		}

	}
}
