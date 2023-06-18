package mqtt_handlers

import (
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"github.com/gocql/gocql"
	"log"
	"server/pkg/db"
	"strings"
	"time"
)

func DeviceStartupHandler(repo *db.DeviceStartupRepo) func(client mqtt.Client, message mqtt.Message) {
	return func(client mqtt.Client, message mqtt.Message) {
		topic := message.Topic()
		topicParts := strings.Split(topic, "/")
		deviceIdString := topicParts[1]
		deviceId, err := gocql.UUIDFromBytes([]byte(deviceIdString))
		if err != nil {
			log.Println(err)
		}
		//fmt.Println("device_startup deviceId:", deviceId, " at timestamp:", timestamp)

		err = repo.Insert(db.DeviceStartup{
			DeviceID:          deviceId,
			ServerTimestamp:   time.Now(),
			TimeAfterStartSec: 0,
		})

	}
}
