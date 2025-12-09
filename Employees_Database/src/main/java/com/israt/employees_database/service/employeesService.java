package com.israt.employees_database.service;

import com.israt.employees_database.entity.employees;
import com.israt.employees_database.repository.databaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class employeesService {

    // Add Employee
    public void addEmployee(employees emp) {
        String sql = "INSERT INTO Employee2 (name, dob, department) VALUES (?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setDate(2, java.sql.Date.valueOf(emp.getDob())); // LocalDate -> SQL Date
            ps.setString(3, emp.getDepartment());

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            System.out.println("Error in addEmployee: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Get All Employees
    public List<employees> getAllEmployees() {
        List<employees> empList = new ArrayList<>();
        String sql = "SELECT * FROM Employee2";

        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                employees emp = new employees();
                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));

                Date dobSql = rs.getDate("dob");           // SQL Date
                if(dobSql != null) {
                    emp.setDob(dobSql.toLocalDate());      // SQL Date -> LocalDate
                }

                emp.setDepartment(rs.getString("department"));
                empList.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("Error in getAllEmployees: " + e.getMessage());
            e.printStackTrace();
        }

        return empList;
    }

    // Get Employee By Id
    public employees getEmployeeById(int id) {
        String sql = "SELECT * FROM Employee2 WHERE id = ?";
        employees emp = null;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new employees();
                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));

                Date dobSql = rs.getDate("dob");
                if(dobSql != null) emp.setDob(dobSql.toLocalDate());

                emp.setDepartment(rs.getString("department"));
            }

        } catch (SQLException e) {
            System.out.println("Error in getEmployeeById: " + e.getMessage());
            e.printStackTrace();
        }

        return emp;
    }

    // Update Employee
    public void updateEmployee(employees emp) {
        String sql = "UPDATE Employee2 SET name = ?, dob = ?, department = ? WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setDate(2, java.sql.Date.valueOf(emp.getDob())); // LocalDate -> SQL Date
            ps.setString(3, emp.getDepartment());
            ps.setLong(4, emp.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Employee updated successfully!");

        } catch (SQLException e) {
            System.out.println("Error in updateEmployee: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee2 WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Employee deleted successfully!");

        } catch (SQLException e) {
            System.out.println("Error in deleteEmployee: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
