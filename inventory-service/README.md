# Inventory Service

## Overview
The **Inventory Service** is a microservice built using **Spring Boot** and **MySQL**. It is part of a larger microservices architecture and is responsible for managing inventory data.

## Features
- Connects to a MySQL database for inventory management.
- Exposes RESTful APIs for inventory operations.
- Configurable via `application.properties`.

## Prerequisites
- **Java 17** or higher
- **Maven 3.8+**
- **Docker** and **Docker Compose**

## Setup and Run

### 1. Clone the Repository
```bash
git clone <repository-url>
cd <repository-folder>

```
### 2. Build the Project
```bash
mvn clean install
```
### 3. Run the Application
```bash
java -jar target/inventory-service-0.0.1-SNAPSHOT.jar
```
### 4. Access the Application
- Open your web browser and navigate to `http://localhost:8082`.
- You can use tools like **Postman** or **cURL** to interact with the REST APIs.
- The default port is `8082`, but you can change it in the `application.properties` file.
- The application will automatically create the database schema if it does not exist.
