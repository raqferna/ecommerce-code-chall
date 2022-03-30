# ecommerce-code-challenge


## Installation


This is a Spring-boot Maven Proyect
Running the API requires JDK 8, Oracle's JDK or OpenJDK.


## Building

Run 'mvn clean install' for install the dependencies and build the project.

Run 'java -jar libere-ecommerce-challenge-0.0.1-SNAPSHOT.jar' ( from location where .jar is generated) for start the app.

The endpoints are exposed on 8080 default PORT.
In the same port you can access the Swagger that documents the API and facilitates the understanding of the same
(Example of Swagger URL in local -> http://localhost:8080/swagger-ui/index.html)


## RESUME
Service created in java, following hexagonal architecture focused on DDD.
I have followed this pattern because layering provides scalability and domain-driven design abstracts business logic and makes it easier to understand.
Although I have added the amqp dependency to allow adding asynchronous events, I have not implemented an event bus as it was beyond the requirements.


## TODO LIST 

-> IMPLEMENT SECURITY IN REQUESTS
-> MORE COVERAGE OF TESTING
-> MORE VALIDATIONS AND ERROR CONTROLS
