*Microservice architecture :* <br />
Sample project to demonstrate microservice architecture using different microservice user-service, address-service, email-service, auth-service
using discovery sever such as Eureka and message broker i.e Rabbitmq.  

Euerka server runs on port : 8761 <br />
User-service/Employee-service runs on port : 8762 <br />
Mail-service runs on port : 8763 <br />
Address-service runss on port : 8764 <br />
Auth-service runs on port : 8765 <br />
Spring cloud gateway is configured on port : 8080 <br />
Config-server runs on port : 8001 <br />

Rabbitmq is running through docker container. <br />

Config server is the configuration store used for dynamically fetching the required config for diffrenet microservices from git. <br />
All the microservice is now fetching config from config-server.
