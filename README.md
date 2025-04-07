# ✈️ Airline Reservation System

A desktop-based application built with **Java Swing** and **MySQL** that allows users to manage airline ticket reservations.
The system supports flight management, customer details, ticket booking, and more.

---

## 📌 Features

- ✅ Add, update, and delete customer records.
- ✅ Book flights and manage ticket details.
- ✅ View flight schedules.
- ✅ User-friendly GUI interface with Java Swing.
- ✅ Persistent storage using MySQL database.

---

## 🛠 Technologies Used

- **Java** (JDK 8+)
- **Java Swing** (GUI)
- **MySQL** (Database)
- **JDBC** (Java Database Connectivity)
- **Eclipse** (optional)

---

## 🖼️ Screenshots

**Login Page**

![Login page](https://github.com/user-attachments/assets/85a53204-aa65-47ae-a105-f10fa867230c)

**Admin Page - Adding Flights**

![Admin page - Add flights](https://github.com/user-attachments/assets/f1e1a3c6-674e-4bc7-bc1c-a313992ca0d6)

**Admin Page - Searching Customers**

![Admin page - Search Customers](https://github.com/user-attachments/assets/ef5512fd-d6a4-4e50-931b-50e6eac87bd8)

**Admin Page - Tickets**

![Admin page - Tickets](https://github.com/user-attachments/assets/0cfc7c97-7210-4213-b779-f1bcf8897f9b)

**AddCustomer**

![AddCustomer](https://github.com/user-attachments/assets/0a7bc787-7f4c-4e60-9fec-79a282deedb1)

**MainPage**

![MainPage](https://github.com/user-attachments/assets/25968e11-f2a7-4fef-bd6b-3750c44b765c)

**TicketBooking**

![TicketBooking](https://github.com/user-attachments/assets/8b6fc8fc-8255-405e-a8ba-c3c8a36bda36)

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java JDK 8 or later
- MySQL Server
- IDE (Eclipse)

### 💾 Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/hedralotfy/Airline_project.git

---
**📂 Database Setup**

Make sure MySQL Server is running.

Open phpMyAdmin or MySQL Workbench.

Create a new database called airlinedb.

Import the file airlinedb.sql from the db folder:

In phpMyAdmin: go to Import tab, choose the file, and execute.

In terminal:

```
mysql -u root -p airline < db/airline.sql
```

Update database connection info in the code (DBConnection.java or equivalent):

```
String url = "jdbc:mysql://localhost/airlinedb";
String user = "root";
String password = "";
```

---

**📚 Required External Libraries**

This project uses external libraries to enhance the UI and date selection features.

📦 Required JAR Files (included in /lib folder):

jcalendar-1.4.jar

jgoodies-common-1.2.0.jar

💡 If your repo doesn't have a lib/ folder yet, create one and place both JAR files inside. Then:

🔗 Add Libraries to Your Project
In Eclipse:

Right-click your project > Build Path > Configure Build Path.

Go to Libraries tab.

Click Add JARs (if local) or Add External JARs (if outside the project).

Select both jcalendar-1.4.jar and jgoodies-common-1.2.0.jar from the /lib directory.

✅ Done! Your project is now ready to use the date picker and run smoothly.

---

**🤔 Why This Project?**

This project was created to explore desktop app development in Java, integrate a relational database, and understand real-world business workflows like flight booking and customer handling.

---

**🧠 What I Learned**

Working with GUI design and layout managers in Java Swing.

Performing CRUD operations using JDBC.

Structuring multi-window desktop applications.

Debugging database connectivity and queries.

---

**📬 Contact**

Hedra Lotfy
📧 Hedralotfy20@gmail.com
🔗 LinkedIn
🔗 GitHub
