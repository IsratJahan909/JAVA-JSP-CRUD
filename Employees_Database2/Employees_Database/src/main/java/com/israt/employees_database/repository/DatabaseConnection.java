package com.israt.employees_database.repository;

import com.israt.employees_database.entity.Employee;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    // IMPORTANT: Replace with your actual database credentials
    // For NetBeans, you will set up a JDBC Resource, but for a standalone WAR, 
    // a simple connection class is often used.
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root"; // **CHANGE THIS**
    
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (name, dob, department) VALUES (?, ?, ?)";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id, name, dob, department FROM employees WHERE id = ?";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT id, name, dob, department FROM employees";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employees WHERE id = ?";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employees SET name = ?, dob = ?, department = ? WHERE id = ?";
    
    // SQL to create the table if it doesn't exist
    public static final String CREATE_TABLE_SQL = 
        "CREATE TABLE IF NOT EXISTS employees (" +
        "  id INT AUTO_INCREMENT PRIMARY KEY," +
        "  name VARCHAR(255) NOT NULL," +
        "  dob DATE," +
        "  department VARCHAR(255)" +
        ")";

    public DatabaseConnection() {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Attempt to create the table on startup (for convenience)
            try (Connection connection = getConnection();
                 Statement statement = connection.createStatement()) {
                statement.execute(CREATE_TABLE_SQL);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error creating employees table.");
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public void insertEmployee(Employee employee) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, employee.getDob() != null ? Date.valueOf(employee.getDob()) : null);
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Employee selectEmployee(int id) {
        Employee employee = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                LocalDate dob = rs.getDate("dob") != null ? rs.getDate("dob").toLocalDate() : null;
                String department = rs.getString("department");
                employee = new Employee(id, name, dob, department);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                LocalDate dob = rs.getDate("dob") != null ? rs.getDate("dob").toLocalDate() : null;
                String department = rs.getString("department");
                employees.add(new Employee(id, name, dob, department));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    public boolean deleteEmployee(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    public boolean updateEmployee(Employee employee) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            statement.setString(1, employee.getName());
            statement.setDate(2, employee.getDob() != null ? Date.valueOf(employee.getDob()) : null);
            statement.setString(3, employee.getDepartment());
            statement.setInt(4, employee.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQL State: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
