# 🎓 CampusCore-Student CRUD – Spring Boot REST API

A simple beginner-level **CRUD (Create, Read, Update, Delete)** project built with **Spring Boot**, **Spring Data JPA**, and **MySQL**.
It manages student records through REST APIs that you can test using **Postman**.

---

## 🛠️ Tech Stack

| Tool | Purpose |
|------|---------|
| Java 17+ | Programming language |
| Spring Boot | Builds the REST API |
| Spring Data JPA + Hibernate | Talks to the database without writing SQL |
| MySQL | Stores student data |
| Maven | Manages dependencies |
| Postman | Tests the API |
| DataGrip | Views and manages the database |

---

## 📁 Project Structure

```
CRUDSpringBootProject
└── src/main
    ├── java/com/project
    │   ├── CRUDSpringBootProject
    │   │   ├── Controller
    │   │   │   └── StudentController.java      → Receives HTTP requests
    │   │   ├── Service
    │   │   │   └── StudentService.java         → Business logic
    │   │   ├── Repository
    │   │   │   └── StudentRepository.java      → Talks to the database
    │   │   ├── Entity
    │   │   │   └── Student.java                → Student table (Java class)
    │   │   └── CrudSpringBootProjectApplication.java  → Main class (starts the app)
    │   └── Databse
    │       └── student_databse.sql             → Sample table + data
    └── resources
        └── application.properties              → Database configuration
```

### What does each layer do?

| Layer | Simple Explanation |
|-------|--------------------|
| **Controller** | The "front door". Receives requests from Postman/frontend and sends back responses. |
| **Service** | The "brain". Contains the logic (e.g., check if a student exists before updating). |
| **Repository** | The "database helper". Saves, finds, updates, and deletes records. |
| **Entity** | A Java class that represents the `student` table in the database. |

---

## 🔄 How the Project Works (Workflow)

```
 Postman / Client
        │   (JSON request)
        ▼
  StudentController     → receives the request
        │
        ▼
  StudentService        → applies logic
        │
        ▼
  StudentRepository     → runs database operations
        │
        ▼
     MySQL Database
        │
        ▼
   Response (JSON) goes back to the client
```

**Example:** When you send a `POST` request to create a student, the controller receives the JSON, the service passes it on, the repository saves it in MySQL, and the saved student is returned as the response.

---

## 🗄️ Database

**Table:** `student`

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT (Primary Key) | Unique student ID |
| name | VARCHAR(255) | Student name |
| email | VARCHAR(255) | Student email |
| age | INT | Student age |
| roll_no | INT | Roll number |
| subject | VARCHAR(255) | Subject name |

A ready-to-use SQL file with the table and sample records is available at:
`src/main/java/com/project/Databse/student_databse.sql`

---

## 🚀 API Endpoints

Base URL: `http://localhost:8080/api/students`

| Operation | Method | Endpoint | Description |
|-----------|--------|----------|-------------|
| Create | `POST` | `/create` | Add a new student |
| Read one | `GET` | `/get/{id}` | Get a student by ID |
| Read all | `GET` | `/getAll` | Get all students |
| Update one | `PUT` | `/update/{id}` | Update a student by ID |
| Update many | `PUT` | `/updateAll` | Update/save a list of students |
| Delete | `DELETE` | `/delete/{id}` | Delete a student by ID |

### Sample JSON (for POST / PUT)

```json
{
  "id": 11,
  "name": "Rahul Patel",
  "email": "rahul@gmail.com",
  "age": 22,
  "rollNo": 111,
  "subject": "Java Backend"
}
```

> 📝 **Note:** The `id` is not auto-generated in this project, so you need to send it in the request body when creating a student.

### Response Status Codes

| Code | Meaning |
|------|---------|
| `201 Created` | Student created successfully |
| `200 OK` | Request successful |
| `404 Not Found` | Student with that ID does not exist |

---

## ▶️ How to Run the Project

### 1. Prerequisites
- Java 17 or higher
- MySQL installed and running
- Maven (or use the included `mvnw`)
- Postman (for testing)

### 2. Clone the repository
```bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>
```

### 3. Create the database
Open MySQL (or DataGrip) and run:
```sql
CREATE DATABASE STUDENT_CRUD_DATABASE;
```
Then run the SQL file `student_databse.sql` to create the table and sample data (optional).

### 4. Configure `application.properties`
Update `src/main/resources/application.properties` with your own MySQL details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/STUDENT_CRUD_DATABASE
spring.datasource.username=my_mysql_username
spring.datasource.password=my_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 5. Run the application
```bash
./mvnw spring-boot:run
```
Or run `CrudSpringBootProjectApplication.java` directly from your IDE.

The app will start at **http://localhost:8080** ✅

### 6. Test with Postman
Use the endpoints above, e.g. `GET http://localhost:8080/api/students/getAll`

---

## 📚 Key Concepts Used (for beginners)

- `@RestController` – marks a class that handles REST API requests and returns JSON.
- `@RequestMapping` – sets the base URL for the controller.
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` – map HTTP methods to Java methods.
- `@RequestBody` – converts incoming JSON into a Java object.
- `@PathVariable` – reads a value from the URL (like the `id`).
- `@Service` – marks the business logic class.
- `@Entity` / `@Id` – maps a Java class to a database table and sets the primary key.
- `JpaRepository` – gives ready-made methods like `save()`, `findById()`, `findAll()`, `deleteById()`.

---

## 👨‍💻 Author

**Your Name**
GitHub: https://github.com/soham-chovatiya

⭐ If this project helped you learn Spring Boot, give it a star!