#pragma once
#include <Arduino.h>
#include <vector>

namespace HANDLER { 
    typedef void(*HandlerFunction)(String topic, String payload); 
    struct Handler { 
    String method; 
    HandlerFunction func; 
    } Handler; 

    
    std::vector<struct Handler> handlers;
    void registerHandler (struct Handler handler) { 
        handlers.push_back(handler); 
    }


    void callback(char *topic, byte *payload, unsigned int length) {
        String topicString = String(topic); 
        String payloadString = String((char*)payload, length);

        // Serial.print("Message arrived in topic: ");
        // // Serial.println(topic);
        // String topicString = String(topic); 

        // Serial.println(topicString); 

        // Serial.print("Message:");
        // String payloadString = String((char*)payload, length);
        // Serial.println(payloadString);
        // Serial.println();
        // Serial.println("-----------------------");

        for (int i = 0; i < handlers.size(); i++){
            auto it = &handlers[i]; 
            if (topicString.startsWith(it->method)){ 
                it->func(topicString, payloadString); 
            }
        }
        
    }
}
