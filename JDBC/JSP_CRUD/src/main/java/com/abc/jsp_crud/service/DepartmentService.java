package com.abc.jsp_crud.service;

import com.abc.jsp_crud.entity.Department;
import com.abc.jsp_crud.entity.Employee;
import com.abc.jsp_crud.repository.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public void save(Department dep) {
        String query = "INSERT INTO department (name, description)  VALUES (?, ?)";
        try {

            Connection conn = DBUtil.getConnection();
            System.out.println("Connected-------------");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dep.getName());
            ps.setString(2, dep.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void update(Department dep) {
         String query = "update department set name = ? , description = ?  where id = ? ";
        try {
            Connection conn = DBUtil.getConnection();
            System.out.println("Connected-------------");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dep.getName());
            ps.setString(2, dep.getDescription());
            ps.setLong(3, dep.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Department> getAll() {
        List<Department> depList = new ArrayList<>();
        String query = " select * from department ";
        try {
            Connection conn = DBUtil.getConnection();
            System.out.println("Connected-------------");
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department dep = new Department(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description")
                );
                depList.add(dep);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return depList;
    }

    public Department getById(Long id) {
        Department dep = null;
        String query = " select * from department where id = ? ";
        try {
            Connection conn = DBUtil.getConnection();
            System.out.println("Connected-------------");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dep = new Department(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return dep;
    }

    public Boolean deleteById(Long id) {
        String query = " delete from department where id = ? ";
        try {
            Connection conn = DBUtil.getConnection();
            System.out.println("Connected-------------");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            if (ps.executeUpdate()>0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

}
