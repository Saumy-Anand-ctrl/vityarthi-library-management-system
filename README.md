# Library Management System

## Project Overview

The Library Management System is a Java-based application developed to simplify and manage common library activities. It allows users to manage books and members, issue and return books, search for books, and maintain library records.

The system uses Java classes and file handling to store and manage data.

## Features

* Add new books
* View all available books
* Search books by ID, title, or author
* Remove books
* Register library members
* View registered members
* Issue books to members
* Return issued books
* View currently issued books
* Store records using text files
* Validate user input

## Technologies Used

* **Programming Language:** Java
* **Concepts:** Object-Oriented Programming (OOP)
* **File Handling:** Java File I/O
* **Data Storage:** Text files
* **Development Environment:** Visual Studio Code / IntelliJ IDEA / Eclipse

## Project Structure

```text
LibraryManagementSystem/
│
├── Main.java
├── Book.java
├── Member.java
├── IssueRecord.java
├── Library.java
├── FileManager.java
├── Validation.java
├── books.txt
├── members.txt
└── issue_records.txt
```

## Functional Modules

### 1. Book Management

This module allows the user to add, view, search, and remove books from the library.

### 2. Member Management

This module allows the user to register members and view member information.

### 3. Issue and Return Management

This module manages book issuing and returning. It also tracks which books are currently issued to members.

### 4. Data Storage

Library information is stored in text files so that data can be retained after the program is closed.

## Requirements

Before running the project, make sure Java is installed on your computer.

You can check Java using:

```bash
java -version
```

You should also have the Java compiler:

```bash
javac -version
```

## How to Run

### Step 1: Open the Project

Open the `LibraryManagementSystem` folder in Visual Studio Code or another Java IDE.

### Step 2: Compile the Program

Open the terminal inside the project folder and run:

```bash
javac *.java
```

### Step 3: Run the Program

Run:

```bash
java Main
```

## Main Menu

The application provides the following options:

```text
1. Add Book
2. View Books
3. Search Book
4. Remove Book
5. Add Member
6. View Members
7. Issue Book
8. Return Book
9. View Issued Books
10. Exit
```

## Data Storage

The system automatically creates and uses the following files:

* `books.txt` – stores book information
* `members.txt` – stores member information
* `issue_records.txt` – stores issued book records

## Testing

The following operations can be tested:

* Adding a new book
* Searching for an existing book
* Registering a new member
* Issuing an available book
* Trying to issue an already issued book
* Returning an issued book
* Removing an available book
* Checking invalid or empty input

## Future Enhancements

The project can be extended in the future by adding:

* Login and user authentication
* Due dates for books
* Fine calculation
* Graphical User Interface (GUI)
* Database connectivity
* Book borrowing history
* Email or notification system

## Conclusion

The Library Management System provides a simple way to manage basic library operations using Java. The project demonstrates Object-Oriented Programming, classes and objects, collections, file handling, input validation, and modular programming.

## Author

**SAUMY ANAND- 25BAI10196**

