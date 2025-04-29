# Order Service

## Overview
The **Order Service** is a microservice built with Spring Boot that handles order management. It integrates with other services like inventory and uses MySQL as the database. The project is designed to demonstrate modern microservice architecture with features like REST APIs, Testcontainers, and OpenFeign.

## Features
- **Order Management**: Create and manage orders.
- **Database Migration**: Uses Flyway for database versioning.
- **Integration Testing**: Testcontainers for MySQL and WireMock for mocking external services.
- **REST API**: Built with Spring Boot and tested using RestAssured.
- **OpenFeign**: For inter-service communication.

## Prerequisites
- Java 21
- Maven 3.8+
- Docker (for Testcontainers)
- MySQL 8.0

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/anhduc0523/order-service.git
cd order-service
```

### Build the Project
```bash
mvn clean install
docker-compose up -d
```