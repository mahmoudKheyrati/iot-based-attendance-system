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


    void setup() {
        pinMode(RELAY_PIN, OUTPUT);
        close();
    }

    void open() {
        digitalWrite(RELAY_PIN, 0);
        state = true;
    }
    void close() {
        digitalWrite(RELAY_PIN, 1);
        state = false;
    }

    void openDoor(int delay) { 
        RELAY::open(); 
        SCHEDULER::schedule({delay, close}); 
        MQTT::publish(LOCK_OPENED_TOPIC, String(time(NULL)).c_str()); 
    }

    bool isOpen() {
        return state;
    }
}