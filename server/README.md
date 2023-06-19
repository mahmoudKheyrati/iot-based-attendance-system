# server

## payload types: 
### receive payload from arduino: 
- device startup message topic=device_startup
- when an employee put his RFID card on the sensor, the arduino send message to topic=request/{device_id} message_format=``{SECONDS_AFTER_START},{CARD_UID}``
- when lock opens the arduino send message to topic=lock_opened/{device_id} message_format= ``{SECONDS_AFTER_START}``
- the current state of the lock sends to the topic=device_state/{device_id} message_format=``{SECONDS_AFTER_START},LED_COLOR_{RGB}``

### send payload to arduino by server: 
- topic=admin_command/{device_id} message_format=``{TIMESTAMP},{LOCK_OPEN, LED_CHANGE_COLOR_{RGB}}`` which R,G and B could be 0 or 1.
- topic=response/{device_id}/{card_uid} message_format=``{TIMESTAMP},{LOCK_OPEN_PERMITTED, LOCK_OPEN_NOT_PERMITTED},{LCD_MESSAGE}``

### Setup
first up and running scylla database and you should create the keyspace in it.

## Generate protobuf for grpc
golang:
```bash
docker run -v $PWD:/defs registry.docker.ir/namely/protoc-all -f service.proto -l go #or go, csharp, etc
```

## Grpcurl comamnds:
```bash
grpcurl  -d '{"device_id": "42564aa8-2119-4ad9-b430-5ad89d90bf75"}' -plaintext localhost:3498 ir.mahmoud.iot_attendance_system.attendanceSystem.ledColor
grpcurl  -d '{"device_id": "42564aa8-2119-4ad9-b430-5ad89d90bf75"}' -plaintext localhost:3498 ir.mahmoud.iot_attendance_system.attendanceSystem.lockOpenedHistory
grpcurl  -d '{"device_id": "42564aa8-2119-4ad9-b430-5ad89d90bf75", "red": 1, "green": 1 , "blue": 0}' -plaintext localhost:3498 ir.mahmoud.iot_attendance_system.attendanceSystem.changeLedColor
grpcurl  -d '{"device_id": "42564aa8-2119-4ad9-b430-5ad89d90bf75"}' -plaintext localhost:3498 ir.mahmoud.iot_attendance_system.attendanceSystem.openDoor 
 grpcurl  -d '{"device_id": "42564aa8-2119-4ad9-b430-5ad89d90bf75"}' -plaintext localhost:3498 ir.mahmoud.iot_attendance_system.attendanceSystem.getAllDeviceIds
``` 
