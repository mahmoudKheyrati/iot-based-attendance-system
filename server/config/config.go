package config

import (
	"fmt"
	"github.com/joho/godotenv"
	"github.com/spf13/viper"
	"log"
	"os"
	"sync"
)

type Config struct {
	ScyllaConfig     ScyllaConfig
	MqttBrokerConfig MqttBrokerConfig
}

type ScyllaConfig struct {
	Host            string
	Port            int
	Username        string
	password        string
	DefaultKeyspace string
}
type MqttBrokerConfig struct {
	Host           string
	Port           int
	ClientId       string
	Username       string
	Password       string
	KeepAliveSec   int
	PingTimeoutSec int
}

var once sync.Once
var config *Config

func NewConfig() *Config {
	err := godotenv.Load()
	if err != nil {
		log.Println(err)
	}
	fmt.Println(os.Environ())

	once.Do(func() {
		viper.SetConfigName("config")
		viper.AutomaticEnv()
		viper.SetConfigType("yaml")
		viper.AddConfigPath("./")
		if err := viper.ReadInConfig(); err != nil {
			log.Fatalln(err)
		}

		config = &Config{
			ScyllaConfig: ScyllaConfig{
				Host:            viper.GetString("scylla.host"),
				Port:            viper.GetInt("scylla.port"),
				Username:        viper.GetString("scylla.username"),
				password:        viper.GetString("scylla.password"),
				DefaultKeyspace: viper.GetString("scylla.default_keyspace"),
			},
			MqttBrokerConfig: MqttBrokerConfig{
				Host:           viper.GetString("mqtt_broker.host"),
				Port:           viper.GetInt("mqtt_broker.port"),
				ClientId:       viper.GetString("mqtt_broker.client_id"),
				Username:       viper.GetString("mqtt_broker.username"),
				Password:       viper.GetString("mqtt_broker.password"),
				KeepAliveSec:   viper.GetInt("mqtt_broker.keepalive_sec"),
				PingTimeoutSec: viper.GetInt("mqtt_broker.ping_timeout_sec"),
			},
		}
	})

	return config
}
