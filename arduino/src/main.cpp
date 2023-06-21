#pragma once
#include <Arduino.h>
#include <led/led.h>
#include <relay/relay.h>
#include <mqtt/mqtt.h>
#include <rfid/rfid.h>
#include <lcd/lcd.h> 
#include <scheduler/scheduler.h>
#include <handler/handler.h>
#include <report/report.h>
#include <time.h>
#include <constants/consts.h>


void splitString(String inputString, char delimiter, String* substrings, int maxSubstrings); 
void subscribeToMqttTopics();
void registerMqttHandlers(); 
void sendStartupMessage();

char requestTopicTemplate[50]; 
void setup() {
    Serial.begin(115200);

    LED::setup();
    RELAY::setup();
    MQTT::setup(HANDLER::callback);
    RFID::setup();
    LCD::setup(); 
    REPORT::setup(); 

    
    sendStartupMessage(); 
  
    subscribeToMqttTopics(); 
    registerMqttHandlers(); 

    sprintf(requestTopicTemplate, "%s/%s",REQUEST_TOPIC, DEVICE_ID); 

    LED::on(LED::GREEN); 
} 

void loop(){
  SCHEDULER::loop(); 
  MQTT::loop(); 
  REPORT::loop(); 
  String uid = RFID::uid(); 
  // Serial.println("here"); 
  if (uid != "") {
    Serial.print("read card with uid: "); 
    Serial.println(uid); 


    char message[50]; 
    sprintf(message, "%s,%s", String(time(NULL)).c_str(), uid ); 
    MQTT::publish(requestTopicTemplate, message); 

  }
    
 }

void sendStartupMessage() { 
  char startUpMessageTemplate[100];
  sprintf(startUpMessageTemplate, "%s/%s", DEVICE_STARTUP_TOPIC, DEVICE_ID); 
  Serial.print("startup topic: "); 
  Serial.println(startUpMessageTemplate); 
  MQTT::publish(startUpMessageTemplate, ""); 
}

void subscribeToMqttTopics() { 
char adminCommandTopicTemplate[100]; 
    sprintf(adminCommandTopicTemplate, "%s/%s", ADMIN_COMMAND_TOPIC,DEVICE_ID); 
    Serial.print("admin command topic: "); 
    Serial.println(adminCommandTopicTemplate); 

    Serial.println(adminCommandTopicTemplate); 

    char responseTopicTemplate[100];
    sprintf(responseTopicTemplate, "%s/%s/+", RESPONSE_TOPIC, DEVICE_ID); 
    Serial.print("response topic: "); 
    Serial.println(responseTopicTemplate); 

    MQTT::subscribe(adminCommandTopicTemplate);
    MQTT::subscribe(responseTopicTemplate);  

}

void registerMqttHandlers() {

    HANDLER::registerHandler({"response", [](String topic, String payload) {
      String topicParts[3]; 
      splitString(topic, '/', topicParts, 3); 
      String cardUid = topicParts[2];

      String payloadParts[3]; 
      splitString(payload, ',',payloadParts, 3); 

      String timestamp = payloadParts[0]; 
      String permited = payloadParts[1]; 
      String lcdMessage = payloadParts[2]; 

      LED::setNoColor(); 

      if (permited == "LOCK_OPEN_PERMITTED") { 
        LED::on(LED::GREEN); 
        
        RELAY::openDoor(2000, cardUid); 
      }else if (permited == "LOCK_OPEN_NOT_PERMITTED") { 
        LED::on(LED::RED); 
        RELAY::close();
      }
      
      SCHEDULER::schedule({2000, LED::setNoColor}); 

      LCD::clearDisplay(); 
      LCD::setCursor(0,0); 
      LCD::showString("Attendance System", 1);
      LCD::showString("\n\n", 1 );
      LCD::showString(lcdMessage, 1);
      // LCD::showString(uid, 1); 

      SCHEDULER::schedule({2000, LCD::clearDisplay}); 

    }}); 

    HANDLER::registerHandler({"admin_command", [](String topic, String payload){

      String parts[2]; 
      splitString(payload,',',parts, 2); 

      String timestamp = parts[0]; 
      String command = parts[1]; 
      if (command.startsWith("LOCK_OPEN")) { 
        Serial.print("lock-open command with timestamp "); 
        Serial.print(timestamp); 
        Serial.println(""); 
        
        LCD::clearDisplay(); 
        LCD::setCursor(0,0); 
        LCD::showString("Attendance System", 1);
        LCD::showString("\n\n", 1 );
        LCD::showString("Lock opened by admin", 1);
        // LCD::showString(uid, 1); 

        SCHEDULER::schedule({2000, LCD::clearDisplay}); 

        // todo: fix admin
        RELAY::openDoor(2000, "admin"); 

      }else if (command.startsWith("LED_CHANGE_COLOR")){ 
        String commandParts[4]; 
        splitString(command, '_', commandParts, 4); 
        String RGB = commandParts[3]; 

        Serial.print("LED_CHANGE_COMMAND with RGB "); 
        Serial.print(RGB); 
        Serial.println("");

        if (RGB[0]=='1') { 
          LED::on(LED::RED); 
        }else { 
           LED::off(LED::RED); 
        }

        if (RGB[1]=='1'){ 
          LED::on(LED::GREEN);
        }else{ 
          LED::off(LED::GREEN); 
        }

        if (RGB[2]=='1'){ 
          LED::on(LED::BLUE);
        }else { 
          LED::off(LED::BLUE); 
        }
        
        
      }

    }}); 

}


void splitString(String inputString, char delimiter, String* substrings, int maxSubstrings) {
  int startIndex = 0;
  int endIndex = 0;
  int substringCount = 0;
  
  while (endIndex < inputString.length() && substringCount < maxSubstrings) {
    endIndex = inputString.indexOf(delimiter, startIndex);
    
    if (endIndex == -1) {
      endIndex = inputString.length();
    }
    
    substrings[substringCount++] = inputString.substring(startIndex, endIndex);
    
    startIndex = endIndex + 1;
  }
}
