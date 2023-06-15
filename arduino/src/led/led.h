#pragma once 
#include <Arduino.h>

//#define RED  27
//#define GREEN 25
//#define BLUE 26

namespace LED {
    typedef int color; 
    const color RED = 27;
    const color GREEN = 25;
    const color BLUE = 26;

    int redIsOn = 0; 
    int greenIsOn = 0; 
    int blueIsOn = 0; 

    void setup() {
        pinMode(RED, OUTPUT);
        pinMode(GREEN, OUTPUT);
        pinMode(BLUE, OUTPUT);
    }

    void on(color c) {
        digitalWrite(c, 1 );
        switch (c){
        case RED:
            redIsOn= 1; 
        break;
        case GREEN:
            greenIsOn = 1; 
            break; 
        case BLUE:
            blueIsOn = 1; 
            break; 
        default:
            break;
        }

    }
    void off(color c ) {
        digitalWrite(c, 0);
        switch (c){
        case RED:
            redIsOn= 0; 
        break;
        case GREEN:
            greenIsOn = 0; 
            break; 
        case BLUE:
            blueIsOn = 0; 
            break; 
        default:
            break;
        }
    }

    void setNoColor() { 
        off(RED); 
        off(GREEN); 
        off(BLUE); 

    }
    int getIsRedOn() { 
        return redIsOn;
    }
    int getIsGreenOn() { 
        return greenIsOn;
    }
    int getIsBlueOn() { 
        return blueIsOn;
    }
}
