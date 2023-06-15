# server

## payload types: 
### receive payload from arduino: 
- when an employee put his RFID card on the sensor, the arduino send message to topic=request/{device_id} message_format=``{SECONDS_AFTER_START},{CARD_UID}``
- when lock opens the arduino send message to topic=lock_opened/{device_id} message_format= ``{SECONDS_AFTER_START}``
- the current state of the lock sends to the topic=device_state/{device_id} message_format=``{SECONDS_AFTER_START},LED_COLOR_{RGB}``

### send payload to arduino by server: 
- topic=admin_command/{device_id} message_format=``{TIMESTAMP},{LOCK_OPEN, LED_CHANGE_COLOR_{RGB}}`` which R,G and B could be 0 or 1.
- topic=response/{device_id}/{card_uid} message_format=``{TIMESTAMP},{LOCK_OPEN_PERMITED, LOCK_OPEN_NOT_PERMITED},{LCD_MESSAGE}``

### Setup
first up and running scylla database and you should create the keyspace in it.