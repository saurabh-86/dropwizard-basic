# DropwizardBasic

Dropwizard framework makes web application development easy by putting together a lot of popular Java libraries together. 
However, a lot of boilerplate is still required to get a quality Dropwizard application setup. 
This project aims to reduce that work, and thereby save time, for developers.
 
What does the DropwizardBasic application include
---

- Project structure created using Dropwizard's `io.dropwizard.archetypes:java-simple` maven archetype
- A Jersey resource `/persons` supporting GET and PUT operations
- A DAO class demonstrating **dropwizard-hibernate** integration (see http://hibernate.org/orm/)
- Auto-discovery of Hibernate entities and Jersey resources
- **Lombok** for reducing boilerplate Java code (see https://projectlombok.org/)
- **MapStruct** for DTO transformations (see http://mapstruct.org/) 
- **Guice** for dependency injection (see https://github.com/google/guice)
- **Liquibase** for database migrations
- **H2** in-memory SQL database for integration tests
- As part of integration tests, the database migrations are automatically run on the H2 database.
- *TODO* DEB file creation using maven plugin 
- *TODO* Partial JSON response feature (see <https://jersey.java.net/documentation/latest/entity-filtering.html>)

How to start the application in Docker
---

1. Using the Docker Terminal, navigate to the `dropwizard-basic` project directory.
2. Execute the command `docker-compose up`. This launches the Dropwizard application and a MySQL server.

How to start the DropwizardBasic application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dropwizard-basic-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
