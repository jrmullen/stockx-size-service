# Stockx True to Size Service

## Prerequisites

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3](https://maven.apache.org/download.cgi)

## Built With

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java JDK
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) - Application Framework
* [Postgres](https://www.postgresql.org/) - Relational Database
* [Hibernate](http://hibernate.org/) - ORM Persistance Tool
* [JUnit4](https://junit.org/junit4/) - Unit Test Framework
* [Mockito](http://site.mockito.org/) - Mocking Framework for Unit Tests

## Database Setup
* [database.sql](https://github.com/jrmullen/stockx-size-service/blob/master/database.sql) contains database creation statements
* [application.properties](https://github.com/jrmullen/stockx-size-service/blob/master/src/main/resources/application.properties) defines database connection properties for the project

## Running the project with Maven
The project can be ran using the  `mvn spring-boot:run` command in the project's root directory

The project can also be ran using the command `./run.sh`. If the script does not execute the file probably 
does not have the approprate permissions. This can be resolved by using the `sudo chmod 755 run.sh` command
from the project's root directory.

The project can also be run from an IDE by running the file [ServiceApplication.java](https://github.com/jrmullen/stockx-size-service/blob/master/src/main/java/com/stockx/service/ServiceApplication.java)

## Services
Once the project is running there are 2 available endpoints:
* http://localhost:8080/api/v1/shoe/new
* http://localhost:8080/api/v1/shoe/true-to-size/{key}

# /api/v1/shoe/new
Creates a new shoe entry in the database

* Method: POST
* Body: Shoe object JSON
* Shoe object:
```
{
 	"display":"Adidas Yeezy",
 	"key":"adidas-yeezy",
 	"true_to_size_score":2
 }
 ```
 * Success response: `200`
 * Failure response: `400`

Making a POST request to the endpoint [http://localhost:8080/api/v1/shoe/new](http://localhost:8080/api/v1/shoe/new) using the above shoe JSON body will result in 
a new entry being inserted into the `shoe` table with a display value of 'Adidas Yeezy', a key of 'adidas-yeezy', 
and a 'true_to_size_score' of 2.

# /api/v1/shoe/true-to-size/{key}
Returns the TrueToSizeCalculation for all shoes with the provided key.

* Method: GET
* Body: none
* Success Response: `200`
* Success Response Body: The TrueToSizeCalculation for the specified shoe
* Failure response: `400`

Making a POST request to the endpoint [http://localhost:8080/api/v1/shoe/true-to-size/adidas-yeezy](http://localhost:8080/api/v1/shoe/true-to-size/adidas-yeezy) will result in
a response body the TrueToSizeCalculation for all shoes in the `shoe` table with a key of `adidas-yeezy`

