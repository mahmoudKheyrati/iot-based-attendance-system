# server

## payload types: 
### receive payload from arduino: 
- when an employee put his RFID card on the sensor, the arduino send message to topic=request message_format=``{DEVICE_ID},{DEVICE_CERT},{TIMESTAMP},{USER_ID},{CERT}``
- when lock state changes the arduino send message to topic=lock_status_changed message_format= ``{DEVICE_ID},{DEVICE_CERT},{TIMESTAMP},{CLOSE, OPEN}``
- when the arduino receives admin command then send the lock state in topic=admin-command-response message_format= ``{DEVICE_ID},{DEVICE_CERT},{TIMESTAMP},{CLOSE, OPEN}``
- the current state of the lock sends to the topic=lock-state message_format=``{DEVICE_ID},{DEVICE_CERT},{TIMESTAMP},{OPEN, CLOSE},{LED_ON, LED_OFF}``

### send payload to arduino by server: 
- topic=admin-command-{DEVICE_ID} message_format=``{DEVICE_ID},{TIMESTAMP},{OPEN, CLOSE, LED_ON, LED_OFF}``
- topic=response-{DEVICE_ID}-{user_id} message_format=``{DEVICE_ID},{TIMESTAMP},{OPEN,CLOSE},{NEW_CERT}``
- topic=update-{DEVICE_ID} message_format: ```{DEVICE_ID},{NEW_DEVICE_ID},{NEW_CERT}```


### Setup
first up and running scylla database and you should create the keyspace in it.