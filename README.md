## Permission Matrix

Admin: 
* delete documents
* view system-wdie security audit logs

Editor:
* Read/Download documents
* Create, update and edit Documents

Viewer:
* Read/ Download Documents only

## Threat Model & Security Mitigations

* Securing the Data from unauthorized Access through Spring security role enforcments and forbidden responses, URLs are only accesed by authorized roles
* Protecting the Data by using short lived JWT Tokens and CORS protections to block any front to backend access methods 
* Each login or access to the vault will be recorded into the audit logs, with timestamps, user actions, and Connection IP address/ username
