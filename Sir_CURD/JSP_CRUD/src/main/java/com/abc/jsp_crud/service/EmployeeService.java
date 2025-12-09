package com.abc.jsp_crud.service;

import com.abc.jsp_crud.entity.Employee;
import com.abc.jsp_crud.repository.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public void insert(Employee e) {
        String sql = "INSERT INTO employees (name, department, salary, dob, gender, skills, full_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getDepartment());
            ps.setDouble(3, e.getSalary());
            ps.setDate(4, Date.valueOf(e.getDob()));
            ps.setString(5, e.getGender());
            ps.setString(6, e.getSkills());
            ps.setBoolean(7, Boolean.TRUE.equals(e.getFullTime()));
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Employee> listAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees ORDER BY id";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setName(rs.getString("name"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
                e.setDob(rs.getDate("dob").toLocalDate());
                e.setGender(rs.getString("gender"));
                e.setSkills(rs.getString("skills"));
                e.setFullTime(rs.getBoolean("full_time"));
                list.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Employee findById(Long id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setName(rs.getString("name"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
                e.setDob(rs.getDate("dob").toLocalDate());
                e.setGender(rs.getString("gender"));
                e.setSkills(rs.getString("skills"));
                e.setFullTime(rs.getBoolean("full_time"));
                return e;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void update(Employee e) {
        String sql = "UPDATE employees SET name=?, department=?, salary=?, dob=?, gender=?, skills=?, full_time=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getDepartment());
            ps.setDouble(3, e.getSalary());
            ps.setDate(4, Date.valueOf(e.getDob()));
            ps.setString(5, e.getGender());
            ps.setString(6, e.getSkills());
            ps.setBoolean(7, Boolean.TRUE.equals(e.getFullTime()));
            ps.setLong(8, e.getId());
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
