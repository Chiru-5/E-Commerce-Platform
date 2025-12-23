# E-Commerce-Platform
E-Commerce Platform using Java


Project Overview
->This project is a fully functional E-Commerce Platform backend built using Spring Boot.
->It demonstrates real-world REST API development with proper layering, database profiling, entity relationships, validation, transactions, and monitoring.

->The application supports complete CRUD operations for all entities and exposes business-level queries commonly required in production-grade e-commerce systems.


Architecture:

The application follows a clean layered architecture:
Controller (REST APIs)
   ↓
Service (Business Logic, @Transactional)
   ↓
Repository (JPA / Custom Queries)
   ↓
Database (H2 / MySQL)


Key Architectural Principles:

->Separation of concerns
->RESTful API design
->Transactional service layer
->Profile-based environment configuration
->Production-ready monitoring using Actuator


Tech Stack:

| Layer                 | Technology                                      |
| --------------------- | ----------------------------------------------- |
| Language              | Java (JDK 25)                                   |
| Framework             | Spring Boot 3.x                                 |
| ORM                   | Spring Data JPA (Hibernate)                     |
| Database              | H2 (dev), MySQL (prod)                          |
| Validation            | Jakarta Validation (`@Valid`, `@NotNull`, etc.) |
| Monitoring            | Spring Boot Actuator                            |
| Boilerplate Reduction | Lombok                                          |
| Build Tool            | Maven                                           |
| IDE                   | IntelliJ IDEA Community Edition                 |





Entity Design & Relationships:
Entities:
->Customer
->Cart
->Order
->OrderItem
->Product
->Category



Customer ↔ Cart
  OneToOne

Customer → Order
  OneToMany / ManyToOne

Order ↔ OrderItem
  OneToMany

OrderItem → Product
  ManyToOne

Product ↔ Category
  ManyToMany


| Relationship        | Type       |
| ------------------- | ---------- |
| Customer ↔ Cart     | OneToOne   |
| Customer → Order    | OneToMany  |
| Order → OrderItem   | OneToMany  |
| OrderItem → Product | ManyToOne  |
| Product ↔ Category  | ManyToMany |




CRUD Operations:
Complete Create, Read, Update, Delete operations are implemented for:
->Customer
->Cart
->Order
->OrderItem
->Product
->Category
All CRUD APIs are exposed via REST endpoints and follow HTTP standards.






API Endpoints:
Customer:

POST   /api/customers
GET    /api/customers/{id}
GET    /api/customers
PUT    /api/customers/{id}
DELETE /api/customers/{id}


Product:

POST   /api/products
GET    /api/products/{id}
GET    /api/products
GET    /api/products/category/{categoryId}
PUT    /api/products/{id}
DELETE /api/products/{id}


Orders:

POST   /api/orders
GET    /api/orders/{id}
GET    /api/orders/customer/{customerId}
GET    /api/orders/status/PENDING


Cart:

GET    /api/cart/{customerId}
POST   /api/cart/{customerId}/items
DELETE /api/cart/items/{itemId}


Configuration & Profiles:

| Profile | Database              |
| ------- | --------------------- |
| `dev`   | H2 In-Memory Database |
| `prod`  | MySQL                 |
