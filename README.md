# Customer Feedback System

A full-stack web application developed using Spring Boot, Thymeleaf, MySQL, HTML, CSS, and JavaScript that allows customers to register, submit feedback, edit reviews, and manage ratings. The system also provides an admin panel to manage customer feedback efficiently.

## Features

### Customer Module
- Customer Registration & Login
- Add Feedback and Ratings
- Edit Submitted Feedback
- Delete Own Feedback
- View Submitted Reviews

### Admin Module
- View All Customer Feedback
- Edit Customer Reviews
- Delete Feedback Entries
- Manage Customer Records

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

### Frontend
- Thymeleaf
- HTML5
- CSS3
- JavaScript
- Bootstrap

### Database
- MySQL

### Tools & IDE
- IntelliJ IDEA
- Maven
- Git & GitHub

## Project Structure

```bash
src
 ├── main
 │   ├── java
 │   ├── resources
 │   │   ├── templates
 │   │   ├── static
 │   │   └── application.properties
 └── test
````

## Installation & Setup

### Clone Repository

```bash
git clone https://github.com/pushpendrahub/Customer-Feedback-System.git
```

### Open Project

Open the project in IntelliJ IDEA or any Java IDE.

### Configure Database

Update your MySQL credentials inside:

```properties
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/customer_feedback
spring.datasource.username=root
spring.datasource.password=yourpassword
```

## Run Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run:

```bash
CustomerAdminApplication.java
```

## Application Screens

* Customer Signup/Login
* Add Feedback Form
* Customer Dashboard
* Admin Dashboard
* Feedback Management Page

## Future Enhancements

* JWT Authentication
* Email Notifications
* Pagination & Search
* REST API Integration
* Responsive UI Improvements

## Learning Outcomes

* Spring Boot CRUD Operations
* Authentication & Authorization
* MVC Architecture
* Database Integration using JPA/Hibernate
* Full Stack Development Concepts

## Author

Pushpendra Singh

GitHub:
[https://github.com/pushpendrahub](https://github.com/pushpendrahub)


