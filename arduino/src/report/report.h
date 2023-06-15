#pragma once 
#include <Arduino.h>
#include <constants/consts.h>
#include <mqtt/mqtt.h>
#include <time.h>
#include <led/led.h>

namespace REPORT { 
    int last_report_millis = 0;
    char deviceStateTopicTemplate[50]; 
    char content[50];
    void setup() { 
        last_report_millis = millis();
        sprintf(deviceStateTopicTemplate, "%s/%s", DEVICE_STATE_TOPIC, DEVICE_ID); 
    }
    void loop() { 
        if (millis() - last_report_millis >= REPORT_INTERVAL_MILLI_SEC ) { 
            Serial.println("reporting ..."); 
            sprintf(content, "%s,LED_COLOR_%d%d%d", String(time(NULL)), LED::getIsRedOn(), LED::getIsGreenOn(), LED::getIsBlueOn()); 
            MQTT::publish(deviceStateTopicTemplate, content); 
            last_report_millis = millis(); 
        }
    }
}