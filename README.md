📚 Library Management System (Java Swing + JDBC)
🧩 Overview

The Library Management System is a desktop-based application built using Java Swing for the GUI and JDBC for database connectivity. It is designed to automate and simplify the process of managing books, members, and transactions (issue/return) in a library. The project uses an SQLite database for data storage, making it lightweight and portable.

⚙️ Features

➕ Add, update, and delete book records

👤 Manage library members and their details

🔍 Search books by title, author, or ID

📖 Issue and return books with date tracking

📦 View all issued and available books

💾 Uses SQLite for persistent data storage

🖥️ Simple and interactive Swing-based GUI

🗂️ Project Structure
LibraryManagementSystem/
│
├── src/
│   ├── Main.java
│   ├── DBConnection.java
│   ├── Book.java
│   ├── Member.java
│   ├── IssueBook.java
│   ├── ReturnBook.java
│   └── LibraryUI.java
│
├── database/
│   ├── library.db
│   └── schema.sql
│
└── README.md

🛠️ Requirements

Java JDK 8 or above

SQLite JDBC driver (included in lib/ folder)

Any IDE (IntelliJ IDEA, Eclipse, or VS Code)

🚀 How to Run

Clone or extract the project ZIP.

Open the project in your preferred Java IDE.

Ensure the SQLite JDBC driver (sqlite-jdbc.jar) is added to your classpath.

Run the Main.java file.

The application GUI will open — start managing your library!

🗃️ Database Setup

The project uses library.db (SQLite).

Tables are automatically created if they don’t exist.

To reset the database, run schema.sql.

🧱 Future Enhancements

Add admin login authentication

Fine calculation for late returns

Migrate to MySQL or PostgreSQL for multi-user access

Generate PDF reports for issued books

👨‍💻 Author

Developed by: M. Varshith Cherry
Language Used: Java (Swing + JDBC)
Database: SQLite
