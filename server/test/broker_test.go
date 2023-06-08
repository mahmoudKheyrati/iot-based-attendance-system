package test

import (
	"fmt"
	"github.com/smartystreets/assertions"
	"log"
	"os"
	"testing"
	"time"

	"github.com/eclipse/paho.mqtt.golang"
)

func TestPublishSubscribe(t *testing.T) {
	//mqtt.DEBUG = log.New(os.Stdout, "--------------", 0)
	mqtt.ERROR = log.New(os.Stdout, "", 0)
	opts := mqtt.NewClientOptions().AddBroker("tcp://localhost:1883").SetClientID("emqx_test_publisher")

	opts.SetKeepAlive(60 * time.Second)
	opts.SetPingTimeout(1 * time.Second)

	publisherClient := mqtt.NewClient(opts)
	if token := publisherClient.Connect(); token.Wait() && token.Error() != nil {
		panic(token.Error())
	}

	subscriberClient := mqtt.NewClient(opts.SetClientID("emqx-test-subscriber"))
	if token2 := subscriberClient.Connect(); token2.Wait() && token2.Error() != nil {
		panic(token2.Error())
	}

	var (
		topic      = "topic/1"
		qos   byte = 2
		//retained      = true
		content = "some content"
	)

	err := publish(publisherClient, topic, qos, true, content)
	assertions.ShouldBeNil(err)

	message, err := subscribe(subscriberClient, topic, qos)
	assertions.ShouldBeNil(err)
	assertions.ShouldEqual(topic, message.Topic())
	assertions.ShouldEqual(message, string(message.Payload()))
}
func publish(c mqtt.Client, topic string, qos byte, retained bool, content string) error {
	token := c.Publish(topic, qos, retained, content)
	token.Wait()
	return token.Error()

}

func subscribe(c mqtt.Client, topic string, qos byte) (mqtt.Message, error) {
	var channel = make(chan mqtt.Message)
	token := c.Subscribe(topic, qos, func(client mqtt.Client, message mqtt.Message) {
		fmt.Println("message received")
		message.Ack()

		channel <- message
	})

	token.Wait()
	err := token.Error()
	message := <-channel
	return message, err

}
