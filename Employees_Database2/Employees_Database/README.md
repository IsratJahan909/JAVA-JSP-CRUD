# Employees_Database

This is a fully functional Employee CRUD (Create, Read, Update, Delete) application built using Jakarta EE (Servlets, JSP, JSTL) and MySQL.

## Prerequisites

1.  **NetBeans IDE**: The project is configured to run easily in NetBeans.
2.  **JDK 17+**: Required by the project's `pom.xml`.
3.  **Apache Tomcat or GlassFish Server**: A Jakarta EE compatible server (e.g., Tomcat 10+ or GlassFish 7+).
4.  **MySQL Database**: A running MySQL server instance.

## Setup Instructions

### 1. Database Setup

You need to create a database and a table for the application to connect to.

1.  **Connect to your MySQL server** (e.g., using MySQL Workbench or the command line).
2.  **Create the database**:
    \`\`\`sql
    CREATE DATABASE employee_db;
    USE employee_db;
    \`\`\`
    *Note: The application will attempt to create the \`employees\` table automatically on the first run.*

### 2. Update Database Credentials

The database connection details are hardcoded in the `DatabaseConnection.java` file for simplicity, as is common in small projects. **You MUST update these details.**

1.  Open the file: `src/main/java/com/israt/employees_database/repository/DatabaseConnection.java`
2.  Change the `JDBC_USER` and `JDBC_PASSWORD` constants to match your MySQL credentials:

    \`\`\`java
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root"; // <-- CHANGE THIS
    private static final String JDBC_PASSWORD = "root_password"; // <-- CHANGE THIS
    \`\`\`

### 3. Run the Project in NetBeans

1.  **Open NetBeans**: Go to `File` -> `Open Project...` and select the `Employees_Database` folder.
2.  **Resolve Dependencies**: NetBeans should automatically detect the Maven project and download all dependencies defined in `pom.xml`.
3.  **Configure Server**: Ensure you have a compatible server (Tomcat 10+ or GlassFish 7+) configured in NetBeans.
4.  **Run**: Right-click the project in the Projects window and select `Run`.

The application should deploy and open in your web browser, redirecting you to the Employee List page.

## Project Structure

The project follows the standard Maven web application structure:

*   `pom.xml`: Maven configuration and dependencies.
*   `src/main/java/`: Java source code (Model, Service, Controller).
    *   `entity/Employee.java`: The data model.
    *   `repository/DatabaseConnection.java`: Handles all database (CRUD) operations. **(Requires credential update)**
    *   `service/EmployeeService.java`: Business logic layer.
    *   `controller/EmployeeServlet.java`: The main Servlet handling all web requests.
*   `src/main/webapp/`: Web content.
    *   `index.jsp`: Redirects to the main employee list.
    *   `WEB-INF/view/`: JSP files for the frontend (list, add, edit).
    *   `WEB-INF/web.xml`: Deployment descriptor (minimal).
\`\`\`
