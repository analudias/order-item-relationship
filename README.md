# Order‑Item Relationship (Spring Boot + JPA)

A simple demo project to practice modeling and implementing a **One-to-Many** relationship between `Order` and `OrderItem` using Spring Boot, Kotlin, PostgreSQL, Docker, and Flyway.

## 🧾 Purpose

This project is part of a hands-on exercise for learning how to:

- Model JPA entities with `@OneToMany` / `@ManyToOne` relationships
- Use `UUID` as primary keys and map them to database schema using Flyway migrations
- Manage environment-specific configurations with Docker and `.env` files
- Apply clean project structure (entities, repository, service, controller)
- Validate correct table creation and data persistence

## 🛠 Technologies & Tools

| Layer                   | Technology / Tool              |
|------------------------|--------------------------------|
| **Backend Framework**   | Spring Boot (Kotlin)           |
| **ORM**                 | Spring Data JPA + Hibernate    |
| **Database**            | PostgreSQL (Docker container)  |
| **Migrations**          | Flyway                         |
| **Build System**        | Gradle (Kotlin DSL)            |
| **Containerization**    | Docker, Docker Compose         |
| **Language**            | Kotlin                         |


## 🚀 Getting Started

1. **Clone the project:**

```bash
git clone https://github.com/analudias/order-item-relationship.git
cd order-item-relationship
```

2. **Check `.env` file content (already included):**

```env
POSTGRES_DB=mydb  
POSTGRES_USER=myuser  
POSTGRES_PASSWORD=mypassword  
HOST_DB_PORT=5432
```

### Start PostgreSQL using Docker Compose:

```bash
docker compose up -d
```
