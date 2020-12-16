# Amigo-microservice
Demo project to understand microservice architecture using three different microservice user-service, address-service, email-service
using discovery sever such as Eureka and message broker i.e Rabbitmq.  

User-service runs on port : 8762
Mail-service runs on port : 8763
Address-service runss on port : 8764

Euerka server runs on port : 8761 

Rabbitmq is running through docker container.

Spring cloud gateway is configured on port : 8080

Spring cloud gateway and employee-service is now fetching configuration from config server.

Config server is running on port : 8001.
Config server is the configuration store used for dynamically fetching the required config for diffrenet microservices from git.
