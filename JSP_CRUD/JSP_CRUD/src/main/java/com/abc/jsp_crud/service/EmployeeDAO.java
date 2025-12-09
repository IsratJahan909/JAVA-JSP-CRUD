/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abc.jsp_crud.service;



import com.abc.jsp_crud.entity.Employee;
import com.abc.jsp_crud.repository.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // CREATE
    public void save(Employee emp) {
        String sql = "INSERT INTO employees (name,email,department,salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            if (emp.getSalary() != null) ps.setDouble(4, emp.getSalary()); else ps.setNull(4, Types.DOUBLE);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) emp.setId(keys.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // READ all
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT id,name,email,department,salary FROM employees ORDER BY id DESC";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getObject("salary") != null ? rs.getDouble("salary") : null);
                list.add(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    // READ by id
    public Employee getById(Long id) {
        String sql = "SELECT id,name,email,department,salary FROM employees WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Employee e = new Employee();
                    e.setId(rs.getLong("id"));
                    e.setName(rs.getString("name"));
                    e.setEmail(rs.getString("email"));
                    e.setDepartment(rs.getString("department"));
                    e.setSalary(rs.getObject("salary") != null ? rs.getDouble("salary") : null);
                    return e;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    // UPDATE
    public void update(Employee emp) {
        String sql = "UPDATE employees SET name=?, email=?, department=?, salary=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            if (emp.getSalary() != null) ps.setDouble(4, emp.getSalary()); else ps.setNull(4, Types.DOUBLE);
            ps.setLong(5, emp.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    // DELETE
    public void delete(Long id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}

