#pragma once

#include <Arduino.h>
#include <scheduler/scheduler.h>
#include <time.h>
#include <mqtt/mqtt.h>
#include <constants/consts.h>


namespace RELAY {
    const int RELAY_PIN = 16;

    void open();
    void close();
    bool isOpen(); 

    bool state ;
    char lockOpenedTopicTemplate[100]; 
    char content[50]; 


    void setup() {
        pinMode(RELAY_PIN, OUTPUT);
        sprintf(lockOpenedTopicTemplate, "%s/%s", LOCK_OPENED_TOPIC, DEVICE_ID); 
        close();
    }

    void open() {
        digitalWrite(RELAY_PIN, 1);
        state = true;
    }
    void close() {
        digitalWrite(RELAY_PIN, 0);
        state = false;
    }

    void openDoor(int delay, String cardUid) { 
        RELAY::open(); 
        SCHEDULER::schedule({delay, close}); 
        sprintf(content, "%s,%s", cardUid.c_str(), String(time(NULL)));
        
        MQTT::publish(lockOpenedTopicTemplate, content); 
    }

    bool isOpen() {
        return state;
    }
}