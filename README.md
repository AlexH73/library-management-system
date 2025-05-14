# 📚 Library Management System

A multi-layered Java Spring Boot application for managing books, authors, and readers in a library. The project demonstrates clean architecture principles with a focus on extensibility and maintainability.

---

## 📦 Technologies

* Java 17+ (e.g., Java 23)
* Spring Boot 3.1.0
* Spring Data JPA
* PostgreSQL (production)
* H2 Database (development profile)
* Lombok
* JUnit 5, Mockito

---

## ✨ Features

* Manage books, authors, and readers
* Register new readers
* Data persistence with PostgreSQL (or H2 for development)
* Service layer with business logic separation
* Ready to extend with REST API endpoints

---

## 🧱 Domain Model Structure

* `Author`
* `Book`
* `Reader`

---

## 🛠 Setup Instructions

1. Ensure you have Java 17+ and Maven installed.
2. (Optional) Install Docker and Docker Compose for PostgreSQL.
3. Clone the repository:

   ```bash
   git clone https://github.com/your-username/library-management-system.git
   cd library-management-system
   ```
4. Start PostgreSQL via Docker:

   ```bash
   docker compose up -d
   # or for legacy plugin:
   docker-compose up -d
   ```
5. Configure database credentials in `src/main/resources/application.properties`.
6. Build the project:

   ```bash
   mvn clean install
   ```
7. Run the application:

    * **Production profile (PostgreSQL, minimal logging):**

      ```bash
      mvn spring-boot:run -Dspring-boot.run.profiles=prod
      ```
    * **Development profile (H2 database, full logging):**

      ```bash
      mvn spring-boot:run -Dspring-boot.run.profiles=dev
      ```

---

## ✅ Running Tests

```bash
mvn test
```

Includes:

* Unit tests for service and repository layers (`src/test`)
* Using JUnit 5 and Mockito frameworks

---

## 📦 Building JAR

```bash
mvn clean package
```

The final JAR will be located at: `target/library-0.0.1-SNAPSHOT.jar`

---

## 👨‍💻 Author

* **AlexH73:** [GitHub](https://github.com/AlexH73) — Developer, Architecture & Documentation

