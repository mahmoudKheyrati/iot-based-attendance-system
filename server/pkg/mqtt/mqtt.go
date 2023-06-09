package mqtt

import (
	"fmt"
	mqtt "github.com/eclipse/paho.mqtt.golang"
	"log"
	"os"
	"time"
)

const (
	AtMostOnce  = 0
	AtLeastOnce = 1
	ExactlyOnce = 2
)

func NewMqttClient(host string, port int, clientId string, keepAliveSec int, pingTimeoutSec int) (mqtt.Client, error) {
	//mqtt.DEBUG = log.New(os.Stdout, "--------------", 0)
	mqtt.ERROR = log.New(os.Stdout, "", 0)
	opts := mqtt.NewClientOptions().AddBroker(fmt.Sprintf("tcp://%s:%d", host, port)).
		SetClientID(clientId).
		SetKeepAlive(time.Duration(keepAliveSec) * time.Second).
		SetPingTimeout(time.Duration(pingTimeoutSec) * time.Second)

	client := mqtt.NewClient(opts)
	if token := client.Connect(); token.Wait() && token.Error() != nil {
		return nil, token.Error()
	}
	return client, nil
}
