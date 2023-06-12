# server

## payload types: 
### receive payload from arduino: 
- when an employee put his RFID card on the sensor, the arduino send message to topic=request message_format=``{TIMESTAMP},{USER_ID},{CA_CERT}``
- when lock state changes the arduino send message to topic=lock_status_changed message_format= ``{TIMESTAMP},{CLOSE, OPEN}``
- when the arduino receives admin command then send the lock state in topic=admin-command-response message_format= ``{TIMESTAMP},{CLOSE, OPEN}``
- the current state of the lock sends to the topic=lock-state message_format=``{TIMESTAMP},{OPEN, CLOSE},{LED_ON, LED_OFF}``

### send payload to arduino by server: 
- topic=admin-command message_format=``{TIMESTAMP},{OPEN, CLOSE, LED_ON, LED_OFF}``
- topic=response-{user_id} message_format=``{TIMESTAMP},{OPEN,CLOSE},{CERT}``


### Setup
first up and running scylla database and you should create the keyspace in it.