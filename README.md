## 📚 Library Management System

Проект по управлению библиотекой с использованием **Spring Boot**, **PostgreSQL** и **Docker**.

---

## 📦 Технологии

* Java 17+
* Spring Boot 3.x
* Spring Data JPA
* PostgreSQL (в Docker)
* H2 (Dev-Mode)
* Maven

---

## 📂 Структура проекта

```
library-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/example/library/
│   │   └── resources/
│   └── test/
│       ├── java/com/example/library/
│       └── resources/
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🐳 Как запустить PostgreSQL через Docker

1. Откройте терминал в корне проекта:

   ```bash
   docker compose up -d
   ```
2. Проверка контейнера:

   ```bash
   docker ps
   ```

> ✅ PostgreSQL будет доступен по адресу `localhost:5432` (логин/пароль — postgres).

---

## ⚙️ Конфигурация приложения

### ▶️ Production (PostgreSQL)

**application.properties:**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/librarydb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

### 🧪 Development (H2 in-memory)

**application-dev.properties:**

```properties
spring.datasource.url=jdbc:h2:mem:librarydb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

---

## 🏁 Сборка и запуск проекта

### ✅ Сборка

```bash
mvn clean install
```

### ✅ Запуск (Production, PostgreSQL)

```bash
mvn spring-boot:run
```

### ✅ Запуск (Development, H2)

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

---

## 🧹 Как отключить логотип Spring Boot и INFO

В `application.properties` добавьте:

```properties
spring.main.banner-mode=off
logging.level.root=WARN
```

---

## 👥 Авторы

**AlexH73:** [GitHub](https://github.com/AlexH73) — разработчик проекта
* 


