
package com.abc.mid_exam_crud.service;

import com.abc.mid_exam_crud.entity.Employee;
import com.abc.mid_exam_crud.repository.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeService {
 



 

    //  Add Employee
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employee (name, designation, salary, joining_date) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDesignation());
            ps.setDouble(3, employee.getSalary());
            ps.setDate(4, Date.valueOf(employee.getJoiningDate()));
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error inserting employee: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //  Update Employee
    public boolean updateEmployee(Employee employee) {
        boolean updated = false;
        String sql = "UPDATE employee SET name = ?, designation = ?, salary = ?, joining_date = ? WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDesignation());
            ps.setDouble(3, employee.getSalary());
            ps.setDate(4, Date.valueOf(employee.getJoiningDate()));
            ps.setLong(5, employee.getId());
            updated = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
            e.printStackTrace();
        }
        return updated;
    }

    //  Delete Employee
    public boolean deleteEmployee(Long id) {
        boolean deleted = false;
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            deleted = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
            e.printStackTrace();
        }
        return deleted;
    }

    //  Get Employee by ID
    public Employee getEmployeeById(Long id) {
        Employee emp = null;
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("designation"),
                        rs.getDouble("salary"),
                        rs.getDate("joining_date").toLocalDate()
                );
            }

        } catch (SQLException e) {
            System.out.println("Error fetching employee: " + e.getMessage());
            e.printStackTrace();
        }
        return emp;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee ORDER BY id DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("designation"),
                        rs.getDouble("salary"),
                        rs.getDate("joining_date").toLocalDate()
                );
                list.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching employee list: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}




