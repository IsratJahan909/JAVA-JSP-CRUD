package com.abc.employee_system.service;

import com.abc.employee_system.entity.Employees;
import com.abc.employee_system.repository.DatabaseConnection;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    // ✅ CREATE
    public void add(Employees emp) {
        
        String sql = "INSERT INTO employees (name, department, salary, dob, gender, skills, fullTime) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
      try (Connection conn = DatabaseConnection.getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);
              )
               {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setDate(4, Date.valueOf(emp.getDob()));
            ps.setString(5, emp.getGender());
            ps.setString(6, emp.getSkills());
            ps.setBoolean(7, emp.getFullTime());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ READ ALL
    public List<Employees> getAll() {
        List<Employees> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = DatabaseConnection.getConnection(); 
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employees emp = new Employees();
                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDob(rs.getDate("dob").toLocalDate());
                emp.setGender(rs.getString("gender"));
                emp.setSkills(rs.getString("skills"));
                emp.setFullTime(rs.getBoolean("fullTime"));
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ✅ READ BY ID
    public Employees getById(Long id) {
        Employees emp = null;
        String sql = "SELECT * FROM employees WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employees();
                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDob(rs.getDate("dob").toLocalDate());
                emp.setGender(rs.getString("gender"));
                emp.setSkills(rs.getString("skills"));
                emp.setFullTime(rs.getBoolean("fullTime"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    // ✅ UPDATE
    public void update(Employees emp) {
        String sql = "UPDATE employees SET name=?, department=?, salary=?, dob=?, gender=?, skills=?, fullTime=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(); 
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setDate(4, Date.valueOf(emp.getDob()));
            ps.setString(5, emp.getGender());
            ps.setString(6, emp.getSkills());
            ps.setBoolean(7, emp.getFullTime());
            ps.setLong(8, emp.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ DELETE
    public void delete(Long id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


