## Gradebook Overview
#### Author: Sujay Gami

### Design And Technologies
Technologies Used: Java 8, Spring-boot Framework, Maven, Docker, Liquibase, and PostgreSQL. 

This microservice leverages a REST API framework to serve reads from the gradebook, writes for student submissions and internal logic to calculate overall grades. A PostgreSQL database is used to store the data of the reads and writes and the app is packaged within a docker container to provide flexibility on where its hosted.

### Data Model
Reference to the data model/schema can be found under the folder (project-resources) where there is an er diagram of the database.

### Endpoints

####GET gradebook/{gbUserId}/getAllStudentAssessmentGrades
- Retrieves all assessments submitted by a student and their corresponding grades. Reference StudentAssessmentGrades model for the expected response structure.

####GET /gradebook/{gbUserId}/getOverallStudentGrade
- Retrieves overall average grade in all courses for a given student.

####GET /gradebook/{courseId}/getOverallCourseGrade
- Retrieves overall average grade for a given course.

####POST /submission/submitAssessment 
- Writes a new assessment record in the database with data populated from the request body (StudentAssessmentScore model). Calculates and returns overall average grade for a student in a course and class overall average. 

### How to Run The Project

Follow these steps to run the app locally:

1) Start the database on a docker container by running this command: `docker run --name postgres-docker -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres`
2) Confirm the container is running with command `docker ps`
3) Run this maven command to build the target jar: `./mvnw clean package`
4) Finally, run the app with this maven command: `./mvnw spring-boot:run`
5) Reference the postman collection located in the (project-resources) folder call the endpoints

### Extra Credit

1) A way to handle sudden spikes in submissions would be to add a load balance in front of this service to help with routing traffic and auto-scaling if the load reaches past defined limits.
2) One of the reasons I chose to integrate the use of Liquibase is because it allows the ability to change the structure or schema of any the tables by adding a new changeset. We can have a new changeset to add or remove users from the roster, etc.
3) There are a few items that I have listed in the section below that need to be addressed before a production release.

### Items remaining given time constraint
- Create design diagram and sequence diagram to illustrate all paths/scenarios
- Add Unit test coverage - currently none 
- Add integration testing/E2E Testing with a framework like cucumber or karate
- Add thorough logging - currently none
- Add exception handling
- Add security features necessary for all APIs such as OAuth
- For Production - Develop a pipeline to deploy the docker container, use docker-compose to package both the app and db
- For Production - Implement caching or create a read-replica of the db if this service is expected to read-intensive