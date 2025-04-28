# 🚗 Car Showroom Management System (CSMS)
This is a Desktop-Based Car Showroom Management System developed in Java using Swing for the user interface and JDBC for database connectivity.
The system helps manage cars, customers, payments, rentals, bills, and overall operations of a car showroom easily and efficiently.

## ✨ Features
### Add Car
Add complete details about a car like Car Number, Brand, Model, Year, Transmission, Fuel Type, Color, Seating Capacity, Price, Discount, Status, and Special Features.

### Add Customer
Add customer details to the system for renting or purchasing a car.

### Payment Management
Handle payment entries and maintain transaction records securely.

### Rent a Car
Manage car rentals with customer linking, rent period, and payment handling.

### Generate Bill
Create and print bills for customer transactions automatically.

### View Details
View complete lists of cars, customers, rentals, and payments in a structured format.

### User Authentication and Logout
Secure login system and logout functionality for better user management.

## 🛠 Technologies Used
- Java (Core + Swing for GUI)
- JDBC (Java Database Connectivity for backend database operations)
- JFrame (Java Swing Component for Windows-based UI)
- MySQL or any RDBMS (for Database storage)

## 📋 How It Works
- Users interact with a modern GUI designed using Java Swing components.
- Backend operations like Insert, Update, Delete, Search are performed using JDBC queries.
### - Different modules are accessible via the sidebar navigation:
  - Add Car
  - Add Customer
  - Payment
  - Rent
  - Bill
  - View Details
  - The "Logout" option allows users to safely end their session.

## 📸 Screenshots

Dashboard View	Add Car Form
(Replace path-to-dashboard-screenshot with the actual image path after uploading screenshots.)

## 🚀 How to Run
- Install Java Development Kit (JDK).
- Install MySQL or your preferred database system.
- Set up the database and tables as required (SQL scripts provided).
- Import the project into any Java IDE (like Eclipse, IntelliJ IDEA, or NetBeans).
- Connect the database using proper JDBC URL, username, and password.
- Run the project.

## 📌 Notes
- Ensure database connectivity is properly configured (check DBConnection class if used).
- Make sure MySQL service is running while using the application.
- User-friendly error messages guide you through any invalid operations.
