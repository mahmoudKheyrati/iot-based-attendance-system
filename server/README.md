# server

## payload types: 
### receive payload from arduino: 
- topic=attempts message_format=``employee-enter-card: {TIMESTAMP} {USER_ID} {CA_CERT}``
- topic=lock_status_changed message_format= ``timestamp: {TIMESTAMP} state={CLOSE, OPEN} ``
- topic=admin-command-response message_format= ``timestamp: {TIMESTAMP} state={CLOSE, OPEN}``

### send payload to arduino by server: 
- topic=admin_commands message_format=``action: open-lock``
- topic=admin_commands message_format=``action: close-lock``
- topic={user_id} message_format=``employee-enter-card: action={OPEN,CLOSE}, new_cert={CERT}``
