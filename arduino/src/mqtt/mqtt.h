#pragma once

#include <Arduino.h>
#include <WiFi.h>
#include <PubSubClient.h>

namespace MQTT {
    // // WiFi
    const char *ssid = "mahmoud"; // Enter your WiFi name
    const char *password = "123abcde";  // Enter WiFi password

    // MQTT Broker
    const char *mqttBroker = "192.168.43.2";// broker address
    const char *mqttUsername = "iotDevice1"; // username for authentication
    const char *mqttPassword = "gjCs41FHgYg354hkiRBE";// password for authentication
    const int mqttPort = 1883;// port of MQTT over TCP
    String clientId = "esp32";

    WiFiClient espClient;
    PubSubClient client(espClient);

    bool wifiState;
    bool brokerState;


    void setup(void (*call)(char *topic, byte *payload, unsigned int length)) {
        // connecting to a WiFi network
        WiFi.begin(ssid, password);
        wifiState = false;
        brokerState = false;
        while (WiFi.status() != WL_CONNECTED) {
            delay(500);
            Serial.println("Connecting to WiFi..");
            Serial.println(WiFi.status());
        }
        wifiState = true;
        Serial.println("Wifi Connected");

        client.setServer(mqttBroker, mqttPort);
        client.setCallback(call);


        while (!client.connected()) {

            clientId += String(WiFi.macAddress());
            Serial.printf("The client %s connects to the public mqtt broker\n", clientId.c_str());
            if (client.connect(clientId.c_str(), mqttUsername, mqttPassword)) {
                Serial.println("Public emqx mqtt broker connected");
            } else {
                Serial.print("failed with state ");
                Serial.print(client.state());
                delay(2000);
            }
        }

        brokerState = true;
        Serial.println("mqtt broker conneted to the topic");


    }

    void subscribe(const char* topic) {
        client.subscribe(topic);
    }
    void publish(const char* topic, const char* message) {
        client.publish(topic, message); // publish to the topic
    }

    bool isWifiConnected() {
        return wifiState;
    }
    bool isBrokerConnected() {
        return brokerState;
    }
    void loop() {
        client.loop();
    }


}