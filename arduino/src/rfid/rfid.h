#pragma once

#include <Arduino.h>
#include <SPI.h>
#include <MFRC522.h>

namespace RFID {
    const int RST_PIN = 16;          // Configurable, see typical pin layout above
    const int SS_PIN = 5;        // Configurable, see typical pin layout above

    MFRC522 mfrc522(SS_PIN, RST_PIN);   // Create MFRC522 instance
    MFRC522::MIFARE_Key key;
    MFRC522::StatusCode status;

    void setup() {
        SPI.begin();                                                  // Init SPI bus
        mfrc522.PCD_Init();                                              // Init MFRC522 card
        Serial.println(F("Read personal data on a MIFARE PICC:"));
    }


    String bytes_to_hex_string(byte *bytes, size_t len) {
        String hex_str;
        for (size_t i = 0; i < len; i++) {
            char hex_chars[3];
            sprintf(hex_chars, "%02X", bytes[i]);
            hex_str += hex_chars;
        }
        return hex_str;
    }


    String lastUid; 
    int lastCardReadTimestamp; 
    
    String uid() {
          if (!mfrc522.PICC_IsNewCardPresent()) {
            return "";
        }

        if (!mfrc522.PICC_ReadCardSerial()) {
            return "";
        }
        
        String uid_hex_str = bytes_to_hex_string(mfrc522.uid.uidByte, mfrc522.uid.size);
        if (lastUid == uid_hex_str && millis() - lastCardReadTimestamp < 3000) { 
            return "";
        }
        lastUid = uid_hex_str; 
        lastCardReadTimestamp = millis();

        return uid_hex_str;
    }

    void dumpInfo() {
        if (!mfrc522.PICC_IsNewCardPresent()) {
            return;
        }
        if (!mfrc522.PICC_ReadCardSerial()) {
            return;
        }
        mfrc522.PICC_DumpToSerial(&(mfrc522.uid));
    }
}