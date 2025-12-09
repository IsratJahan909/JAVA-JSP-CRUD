# Product CRUD Web Application (Maven, Servlet/JSP, MySQL)

This project provides a complete **CRUD (Create, Read, Update, Delete)** web application for a `Product` entity, using **MySQL** with **JDBC**, structured with a layered architecture (`Entity`, `Repository`, `Service`, `Controller/Servlet`).

It is a standard **Maven Web Application** using **Jakarta EE (Servlet/JSP)**, designed to be deployed on a **Tomcat** server (version 10+ is recommended for Jakarta EE 6.0 support).

## Project Structure

The application follows the standard Maven Webapp structure:

| Directory/File | Description |
| :--- | :--- |
| `pom.xml` | Maven configuration file, including dependencies for Jakarta Servlet, MySQL Connector/J, and build plugins. |
| `db_setup.sql` | SQL script to create the database and table. |
| `src/main/java/...` | Contains the Java source code for the layered architecture. |
| `src/main/java/.../entity/Product.java` | The data model. |
| `src/main/java/.../repository/ProductRepository.java` | Handles all JDBC/MySQL operations. |
| `src/main/java/.../service/ProductService.java` | Contains business logic. |
| `src/main/java/.../controller/ProductServlet.java` | The main Servlet (Controller) handling all web requests (`/products`). |
| `src/main/java/.../DBConnection.java` | Utility class for managing the MySQL connection. |
| `src/main/webapp/` | Contains the web resources (JSP files). |
| `src/main/webapp/index.jsp` | Redirects to the product list. |
| `src/main/webapp/product-list.jsp` | Displays all products (Read All). |
| `src/main/webapp/product-form.jsp` | Form for creating and editing products (Create/Update). |
| `src/main/webapp/product-view.jsp` | Displays a single product (Read By ID). |

## Setup and Execution Guide

Follow these steps to set up and run the project, which is easily importable into NetBeans, IntelliJ IDEA, or Eclipse.

### 1. Database Setup (MySQL)

1.  **Start your MySQL Server.**
2.  **Execute the SQL script:**
    The file `db_setup.sql` contains the necessary commands to create the `product_db` database and the `product` table, along with some initial data.

### 2. Configure Database Credentials

Open the file `src/main/java/com/example/product/DBConnection.java` and update the connection details with your MySQL credentials:

```java
// File: DBConnection.java
private static final String URL = "jdbc:mysql://localhost:3306/product_db?useSSL=false&serverTimezone=UTC";
private static final String USER = "root"; // <-- CHANGE THIS
private static final String PASSWORD = "password"; // <-- CHANGE THIS
```

### 3. Import and Run in NetBeans

1.  **Open NetBeans.**
2.  Go to **File > Open Project...**
3.  Navigate to the `product-crud-webapp` directory and select it. NetBeans will recognize the `pom.xml` file and import it as a standard **Maven Web Application**.
4.  **Ensure your Tomcat Server is configured** in NetBeans (Tools -> Servers). You need a version that supports **Jakarta EE 6.0** (e.g., Tomcat 10 or later).
5.  **Run the project:**
    *   Right-click on the project name in the Projects window.
    *   Select **Run**.

The application will deploy to your configured Tomcat server, and your browser will open to the product list page (e.g., `http://localhost:8080/product-crud-webapp/products`). You can then perform all CRUD operations through the web interface.
