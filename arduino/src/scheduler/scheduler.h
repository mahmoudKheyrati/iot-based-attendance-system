#pragma once 
#include <vector>
#include <Arduino.h>

namespace SCHEDULER { 
    typedef void (*jobFunction)(); 
    struct JOB {
        int delay;
        jobFunction func;
        int startMillis; 
    } JOB; 

    std::vector<struct JOB> jobs; 

    void schedule(struct JOB job) {
        job.startMillis = millis();  
        jobs.push_back(job); 
    }
    
    void loop() { 
        std::vector<int> index_to_remove; 
        for (int i = 0; i < jobs.size(); i++){
            auto it = &jobs[i]; 
            if (millis() - it->startMillis >= it->delay) { 
                it -> func (); 
                index_to_remove.push_back(i);
                // Serial.println(it->delay);
            }
        }
        
        for (int i = index_to_remove.size() -1 ; i >=0  ; i--){
            int a = index_to_remove[i]; 
            // Serial.print("Remove: ");
            // Serial.print(a);
            // Serial.print(" "); 
            // Serial.println(jobs[a].delay); 
            jobs.erase(jobs.begin() + a);

        }

    }
}