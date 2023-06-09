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

type Config struct {
	Host           string
	Port           int
	ClientId       string
	Username       string
	Password       string
	KeepAliveSec   int
	PingTimeoutSec int
}

func NewMqttClient(config Config) (mqtt.Client, error) {
	//mqtt.DEBUG = log.New(os.Stdout, "--------------", 0)
	mqtt.ERROR = log.New(os.Stdout, "", 0)
	opts := mqtt.NewClientOptions().AddBroker(fmt.Sprintf("tcp://%s:%d", config.Host, config.Port)).
		SetClientID(config.ClientId).
		SetKeepAlive(time.Duration(config.KeepAliveSec) * time.Second).
		SetPingTimeout(time.Duration(config.PingTimeoutSec) * time.Second)

	client := mqtt.NewClient(opts)
	if token := client.Connect(); token.Wait() && token.Error() != nil {
		return nil, token.Error()
	}
	return client, nil
}
