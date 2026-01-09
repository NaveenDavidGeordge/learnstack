# LearnTrack – Student & Course Management System (Core Java)

## 📌 Project Overview

**LearnTrack** is a console-based **Student & Course Management System** built using **Core Java**.  
The application allows an admin to manage:

- Students
- Courses
- Enrollments

---

## 🎯 Learning Objectives Covered

- Java setup and compilation using JDK
- Understanding JVM, JRE, and bytecode
- Core Java syntax and control flow
- Object-Oriented Programming
    - Encapsulation
    - Inheritance
    - Polymorphism
- Static members and utility classes
- Collections (`ArrayList`)
- Basic exception handling
- Menu-driven console applications
- Clean and modular project structure

---

## 🏗️ Project Structure
com.airtribe.learntrack
│
├── entity
│   ├── Person.java
│   ├── Student.java
│   ├── Course.java
│   └── Enrollment.java
│
├── service
│   ├── StudentService.java
│   ├── CourseService.java
│   └── EnrollmentService.java
│
├── Main.java
│   
│
├── util
│   └── IdGenerator.java
│
├── exception
└── EntityNotFoundException.java

---

### Class Relationships Overview

- **Person** (Base Class)
    - Fields: `id`, `firstName`, `lastName`, `email`
    - Method: `getDisplayName()`

- **Student** extends **Person**
    - Fields: `batch`, `active`
    - Overrides `getDisplayName()`
    - Demonstrates **inheritance and polymorphism**

- **Course**
    - Fields: `id`, `courseName`, `description`, `durationInWeeks`, `active`

- **Enrollment**
    - Links `Student` and `Course` using IDs
    - Contains enrollment date and status

- **Service Classes**
    - Handle business logic using `ArrayList`
    - `StudentService`
    - `CourseService`
    - `EnrollmentService`

- **Utility Class**
    - `IdGenerator` uses **static variables and methods** to generate unique IDs

- **UI Layer**
    - `Main.java` handles menu display and user input

---

## ⚙️ How to Compile and Run

### Prerequisites
- Java JDK 8 or above
- Command line or any IDE (IntelliJ / Eclipse / VS Code)

### Compile
```bash
javac com/airtribe/learntrack/ui/Main.java
```
### Run 
```bash
java com.airtribe.learntrack.ui.Main
```
---

##  Application Features

### Student Management
- Add new students
- View all students
- Search student by ID
- Deactivate students instead of deleting

### Course Management
- Add new courses
- View all courses
- Activate / Deactivate courses

### Enrollment Management
- Enroll a student in a course
- View enrollments for a student
- Track enrollment status

---

## ⚠️ Exception Handling

- Custom Exception: `EntityNotFoundException`

### Handles:
- Invalid menu options
- Non-existent student or course IDs
- Invalid numeric input

The application displays user-friendly error messages and does not crash on invalid input.

---

## 🧹 Clean Code Practices

- Encapsulation using private fields with getters and setters
- Small, meaningful, and reusable methods
- Clear separation of concerns:
    - UI layer
    - Service layer
    - Entity layer
- Proper package structure
- No unused or redundant code

---

## 🔗 Submission Details

- **Repository Link:**  
  https://github.com/NaveenDavidGeordge/learnstack

- **Submission Method:** Pull Request

- **Includes:**
    - Source code
    - `README.md`  

