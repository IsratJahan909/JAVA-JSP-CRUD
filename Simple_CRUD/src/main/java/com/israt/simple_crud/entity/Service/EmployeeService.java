
package com.israt.simple_crud.entity.Service;

import com.israt.simple_crud.entity.Employee;
import com.israt.simple_crud.entity.Repository.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class EmployeeService {
    public  void addEmployee(Employee emp ) {
        String sql = "Insert intto employee (name, designation, salary) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDesignation());
            ps.setDouble(3, emp.getSalary());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
