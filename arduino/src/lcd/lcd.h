#pragma once

#include <Arduino.h>
#include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

#define SCREEN_WIDTH 128 // OLED display width, in pixels
#define SCREEN_HEIGHT 64 // OLED display height, in pixels


#define OLED_RESET     -1 // Reset pin # (or -1 if sharing Arduino reset pin)
#define SCREEN_ADDRESS 0x3C ///< See datasheet for Address; 0x3D for 128x64, 0x3C for 128x32

Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);

namespace LCD {


    void testdrawchar(void) {
        display.clearDisplay();

        display.setTextSize(1);      // Normal 1:1 pixel scale
        display.setTextColor(SSD1306_WHITE); // Draw white text
        display.setCursor(0, 0);     // Start at top-left corner
        display.cp437(true);         // Use full 256 char 'Code Page 437' font

        // Not all the characters will fit on the display. This is normal.
        // Library will draw what it can and the rest will be clipped.
        for (int16_t i = 0; i < 256; i++) {
            if (i == '\n') display.write(' ');
            else display.write(i);
        }

        display.display();
        delay(2000);
    }

    void clearDisplay() {
        display.clearDisplay();
        display.display();
    }

    void setCursor(int x, int y) {
        display.setCursor(x, y);
    }

    void showString(String text, int textSize) {

        display.setTextSize(textSize);      // Normal 1:1 pixel scale
        display.setTextColor(SSD1306_WHITE); // Draw white text
        display.cp437(true);         // Use full 256 char 'Code Page 437' font


        for (char c: text) {
            display.write(c);
        }
        display.display();

    }

    void showStringWithScroll(String text) {
        display.clearDisplay();

        display.setTextSize(1); // Draw 2X-scale text
        display.setTextColor(SSD1306_WHITE);
        display.setCursor(10, 0);
        display.println(text);
        display.display();      // Show initial text
        delay(100);

        // Scroll in various directions, pausing in-between:
        display.startscrollright(0x00, 0x0F);
        delay(2000);
        display.stopscroll();
        delay(1000);
        display.startscrollleft(0x00, 0x0F);
        delay(2000);
        display.stopscroll();
        delay(1000);
        display.startscrolldiagright(0x00, 0x07);
        delay(2000);
        display.startscrolldiagleft(0x00, 0x07);
        delay(2000);
        display.stopscroll();
        delay(1000);
    }

    Adafruit_SSD1306 getDisplay() { 
        return display; 
    }

    void setup() {
        if (!display.begin(SSD1306_SWITCHCAPVCC, SCREEN_ADDRESS)) {
            Serial.println(F("SSD1306 allocation failed"));
            for (;;);
        }
        display.clearDisplay();
        display.display();
    }
}




