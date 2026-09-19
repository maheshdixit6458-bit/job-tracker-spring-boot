# Job Tracker

Job Tracker is a Spring Boot application for managing job applications. It helps a user track companies, job roles, application status, and the dates they applied, so they can keep an organized record of their job search.

## Project overview

This repository contains a backend API for a simple job tracking system. The application stores:

- Job application details such as role and status
- User information
- Company information
- Application dates

The app is built with Java 17 and Spring Boot 3.x.

## Technology stack

- Java 17
- Spring Boot 3.5.11
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Springdoc OpenAPI (Swagger UI)

## Repository structure

```text
job-tracker-spring-boot/
??? README.md
??? .gitignore
??? .mvn/
??? mvnw
??? mvnw.cmd
??? jobtracker/
?   ??? pom.xml
?   ??? src/
?       ??? main/
?       ?   ??? java/
?       ?   ?   ??? com/jobtracker/jobtracker/
?       ?   ?       ??? controller/
?       ?   ?       ??? dto/
?       ?   ?       ??? entity/
?       ?   ?       ??? exception/
?       ?   ?       ??? repository/
?       ?   ?       ??? service/
?       ?   ??? resources/
?       ?       ??? application.properties
?       ??? test/
??? .idea/
```

## Main application flow

The application is centered around the `JobApplication` entity and exposes REST endpoints under `/applications`.

Key domain objects:

- `User`: stores applicant name and email
- `Company`: stores company name and location
- `JobApplication`: links a user, company, job role, status, and applied date

The controller layer exposes the CRUD-style API used to create, read, and delete job applications.

## API endpoints

Base URL: `http://localhost:8080`

### Job applications

- `POST /applications` - Create a new application
- `GET /applications?page={page}&size={size}` - Get paginated applications
- `GET /applications/{id}` - Get one application by ID
- `DELETE /applications/{id}` - Delete an application

## Swagger / API documentation

This project includes Springdoc OpenAPI support, so the API documentation is available at:

- `http://localhost:8080/swagger-ui/index.html`

## Prerequisites

Before running the project, make sure you have:

- Java 17 or above
- Maven or the included Maven wrapper (`mvnw`)
- MySQL installed and running locally

## Local setup

1. Open MySQL and create a database named `job_tracker`.
2. Update the database username and secret in:
   - `jobtracker/src/main/resources/application.properties`
3. Save the file with your local MySQL connection details.
4. From the project root, run:

```bash
cd jobtracker
./mvnw spring-boot:run
```

On Windows:

```powershell
cd jobtracker
mvnw.cmd spring-boot:run
```

## Default configuration

The app uses the following Spring configuration pattern:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/job_tracker
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

Add your local MySQL secret in the datasource section of `application.properties` before running the app.

This means Hibernate will create or update the schema automatically based on the entity models.

## Development notes

- `jobtracker/src/main/java` contains the application code.
- `jobtracker/src/main/resources/application.properties` holds local environment configuration.
- The project is currently structured as a backend-only API and does not include a frontend.
- If you are adding new features, keep the code organized under the Spring Boot package structure: `controller`, `service`, `repository`, `entity`, and `dto`.

## Typical workflow for a new developer

1. Clone the repository.
2. Open the project in IntelliJ IDEA or VS Code.
3. Create the MySQL database.
4. Configure the datasource credentials.
5. Run the application.
6. Use Swagger UI or Postman to test the `/applications` API.

## Good next improvements

This project is a solid starting point for a job tracker backend, and possible future enhancements include:

- User authentication and authorization
- Search and filtering by status or company
- Job notes and follow-up reminders
- Email notifications and dashboard analytics
- Frontend integration with React or Angular

## License

This project does not currently declare a specific license. If you are distributing or collaborating on it, confirm the intended licensing before publishing.
