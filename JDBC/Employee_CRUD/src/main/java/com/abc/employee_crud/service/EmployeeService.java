//
//package com.abc.employee_crud.service;
//
//import com.abc.employee_crud.entity.Employee;
//import com.abc.employee_crud.repository.DatabaseConnection;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class EmployeeService {
//    public void addEmployee(Employee emp) {
//        String sql = "INSERT INTO Employee2 (name, dob, department) VALUES (?, ?, ?)";
//
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, emp.getName());
//            ps.setDate(2, emp.getDob());
//            ps.setString(3, emp.getDepartment());
//
//            int rows = ps.executeUpdate();
//            if (rows > 0) {
//                System.out.println("Employee added successfully!");
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error in addEmployee: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//   
//    public List<Employee> getAllEmployees() {
//        List<Employee> empList = new ArrayList<>();
//        String sql = "SELECT * FROM Employee2";
//
//        try (Connection conn = DatabaseConnection.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                Employee emp = new Employee();
//                emp.setId(rs.getLong("id"));
//                emp.setName(rs.getString("name"));
//                emp.setDob(rs.getDate("dob"));
//                emp.setDepartment(rs.getString("department"));
//                empList.add(emp);
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error in getAllEmployees: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return empList;
//    }
//
//  
//    public Employee getEmployeeById(int id) {
//        String sql = "SELECT * FROM Employee2 WHERE id = ?";
//        Employee emp = null;
//
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setLong(1, id);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                emp = new Employee();
//                emp.setId(rs.getLong("id"));
//                emp.setName(rs.getString("name"));
//                emp.setDob(rs.getDate("dob"));
//                emp.setDepartment(rs.getString("department"));
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error in getEmployeeById: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        return emp;
//    }
//
//   
//    public void updateEmployee(Employee emp) {
//        String sql = "UPDATE Employee2 SET name = ?, dob = ?, department = ? WHERE id = ?";
//
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, emp.getName());
//            ps.setDate(2, emp.getDob());
//            ps.setString(3, emp.getDepartment());
//            ps.setLong(4, emp.getId());
//
//            int rows = ps.executeUpdate();
//            if (rows > 0) {
//                System.out.println("Employee updated successfully!");
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error in updateEmployee: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//
//    public void deleteEmployee(int id) {
//        String sql = "DELETE FROM Employee2 WHERE id = ?";
//
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setLong(1, id);
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//                System.out.println("Employee deleted successfully!");
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error in deleteEmployee: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
