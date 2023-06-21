package mqtt_handlers

import (
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"log"
	"server/pkg/db"
	"strings"
	"time"
)

func DeviceStartupHandler(repo *db.DeviceStartupRepo) func(client mqtt.Client, message mqtt.Message) {
	return func(client mqtt.Client, message mqtt.Message) {
		topic := message.Topic()
		topicParts := strings.Split(topic, "/")
		deviceId := topicParts[1]

		log.Println("device_startup deviceId:", deviceId, " at timestamp:", time.Now())

		err := repo.Insert(db.DeviceStartup{
			DeviceID:          deviceId,
			ServerTimestamp:   time.Now(),
			TimeAfterStartSec: 0,
		})
		if err != nil {
			log.Println(err)
		}

	}
}
