# Student Grade Management System
___
### Spring Boot Application

---
There is a school with 3 course in it. Theese 3 course are being taught in this school: Mathematics, Physics, Chemistry
Avarage grade, calculated according to 2 exams in a year. Avarage grade should be more than 50 for passing course.
There are two school years, one active (2020-2021 school year) and one passive (2019-2020 school year).
Students have grades and average grades for both active and passive school years.

<!--
#### Requirements

• The API will expose an endpoint which accepts the user information (customerID,
initialCredit).

• Once the endpoint is called, a new account will be opened connected to the user whose ID is
customerID.

• Also, if initialCredit is not 0, a transaction will be sent to the new account.

• Another Endpoint will output the user information showing Name, Surname, balance, and
transactions of the accounts. -->
___
The application has 3 apis
* StudentAPI for CRUP operations
* CourseAPI for CRUP operations
* StudentCourseAPI for assing any course to any student

```html
POST /api/v1/course/add - creates a new course
GET /api/v1/course/getbycode/{code} - retrieves a student according to identity
DELETE /api/v1/course/{code} - deletes course
PUT /api/v1/course/{code} - updates course
```
```html
POST /api/v1/student/addCourse - creates a new student
GET /api/v1/student/getbyid/{identity} - retrieves a student according to identity
GET /api/v1/student/getall - retrieves all students 
DELETE /api/v1/student/{identity} - deletes student
PUT /api/v1/student/{identity} - updates student
```
```html
POST /api/v1/studentcourse/add - creates a new student
POST /api/v1/studentcourse/getGradesOfStudent - retrives list all the grades and avarage grade of a student according to the school year code, course code and student id that will be given
POST /api/v1/studentcourse/getGradesOfAllStudents - list all the grades and avarage grade of all students according to the school year code and course code that will be given.
GET /api/v1/studentcourse/getbyid/{identity} - retrieves a studentcourse according to identity
GET /api/v1/studentcourse/getall - retrieves all studentcourses 
DELETE /api/v1/studentcourse/{identity} - deletes studentcourse
PUT /api/v1/studentcourse/{identity} - updates studentcourse
```
JUnit test coverage is 100% as well as unit and integration tests are available.


### Tech Stack

---
- Java 17
- Spring Boot
- Spring Data JPA
- Validation
- Restful API
- Swagger documentation
- H2 In memory database  
- Docker
- JUnit 5


### Prerequisites

---
- Maven
- Docker

### Run & Build

---
There are 2 ways of run & build the application.

#### Docker Compose

For docker compose usage, docker images already push to docker.io

You just need to run `docker-compose up` command
___
*$PORT: 8080*
```ssh
$ cd school
$ docker-compose up
```

#### Maven

For maven usage, you need to change `proxy` value in the `account-fe/package.json` 
file by `"http://localhost:8080"` due to the default value has been settled for docker image network proxy.
___
*$PORT: 8080*
```ssh
$ cd school
$ mvn clean install
$ mvn spring-boot:run
```

### Swagger UI will be run on this url
`http://localhost:8080/api/v1/swagger-ui.html`
