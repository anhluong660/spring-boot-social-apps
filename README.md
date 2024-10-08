# Social-Apps
Social Networking Apps Demo

Microservice Application & Spring Boot Framework

---
### Setup requirement
- Spring boot 3.2.9
- Java 17
- MongoDB
- Mysql Database
- Redis
- Kafka
- Docker

---
### Service In Apps
+ Gateway: Port 8080
+ +
+ User Manager: Port 9001
+ Messenger: Port 9002
+ Social Service: Port 9003
+ +
+ File Service: Port 9200
+ Server Discovery: Port 8781
+ Analysis Metric: Port 9300

---
### Apps Introduction
+ Authentication with JWT (JSON Web Token)
+ Microservice with Spring Cloud
+ Server discovery support balancing with Eureka Netflix
+ Generate unique user id by redis lock
+ Chat Friend and Group Chat with Web Socket
+ Cache member list by redisson
+ Use Kafka send log tracking
+ Deploy by docker