-- NOTE:
-- This SQL file contains the actual database table structure and records exported from MySQL using DataGrip.
-- The MySQL database is connected to the Spring Boot application through Spring Data JPA and Hibernate.
-- DataGrip is used to view and manage the database, tables, and records.
-- This file is provided for reference and understanding and can be used to recreate the exported database structure and records.

CREATE TABLE student
(
id      BIGINT       NOT NULL PRIMARY KEY,
age     INT          NOT NULL,
email   VARCHAR(255) NULL,
name    VARCHAR(255) NULL,
roll_no INT          NOT NULL,
subject VARCHAR(255) NULL
);

insert into STUDENT_CRUD_DATABASE.student (id, age, email, name, roll_no, subject)
values  (1, 22, 'rahul@gmail.com', 'Rahul Patel', 101, 'Java Backend'),
        (2, 22, 'arun@gmail.com', 'Arun Patel', 102, 'Java Backend'),
        (4, 21, 'dev@gmail.com', 'Dev', 104, 'Python(Data Science)'),
        (7, 21, 'riya@gmail.com', 'Riya Joshi', 107, 'Python Programming'),
        (8, 23, 'harsh@gmail.com', 'Harsh Trivedi', 108, 'Computer Networks'),
        (9, 22, 'ananya@gmail.com', 'Ananya Shah', 109, 'Software Engineering'),
        (10, 25, 'dev@gmail.com', 'Dev Patel', 110, 'Hibernate ORM');