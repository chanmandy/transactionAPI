# Pismo Backend Test

Transactions API Routine developed as a part of Pismo Backend Developer Interview Process.

## Technologies Used

* Java 17
* Maven
* Spring Boot with Data JPA
* Docker, Docker Compose
* MySQL
* Swagger
* JUnit + Mockito

## Compiling the project

Project can be compiled using standard maven command as follows:

```bash
mvn clean install
 ```

## Running the project

Code runs on docker and uses 2 containers, one for MySQL Database and one for API application 
It can be run with docker-compose command as follows:

```bash
docker-compose up --build
 ```

## API Documentation
Once the project has been loaded, docs will be available at below URL:
* localhost:8080/swagger-ui/index.html/