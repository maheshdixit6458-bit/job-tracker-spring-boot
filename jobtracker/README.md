# Job Tracker API

This is the Spring Boot backend for the Job Tracker application.

## About the project

The app stores and manages job applications, including:

- job role and application status
- company information
- applicant details
- application dates

## Project location

The repository-level documentation and overview are available in the parent folder:

- `../README.md`

## Quick start

1. Create a MySQL database named `job_tracker`.
2. Update the datasource settings in `src/main/resources/application.properties`.
3. Run the app:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
mvnw.cmd spring-boot:run
```

## API docs

Swagger UI is available after the app starts at:

- `http://localhost:8080/swagger-ui/index.html`

## Main endpoints

- `POST /applications`
- `GET /applications?page={page}&size={size}`
- `GET /applications/{id}`
- `DELETE /applications/{id}`
