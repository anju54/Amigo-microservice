# Amigo-microservice
Sample project to demonstrate microservice architecture using different microservice user-service, address-service, email-service, auth-service
using discovery sever such as Eureka and message broker i.e Rabbitmq.  

Euerka server runs on port : 8761
User-service/Employee-service runs on port : 8762
Mail-service runs on port : 8763
Address-service runss on port : 8764 
Auth-service runs on port : 8765
Spring cloud gateway is configured on port : 8080
Config-server runs on port : 8001

Rabbitmq is running through docker container.

Config server is the configuration store used for dynamically fetching the required config for diffrenet microservices from git.
All the microservice is now fetching config from config-server.
