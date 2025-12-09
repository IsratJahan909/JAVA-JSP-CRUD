
package com.israt.jsp_maven.service;

import com.israt.jsp_maven.entity.Student;
import com.israt.jsp_maven.repository.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class StuService {

    public void create(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, email, description, date_of_birth, updated_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getDescription());
            stmt.setDate(4, Date.valueOf(student.getDateOfBirth()));
            stmt.setTimestamp(5, Timestamp.valueOf(student.getUpdatedAt()));
            stmt.executeUpdate();
        }
    }

    public List<Student> readAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setDescription(rs.getString("description"));
                s.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                s.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                students.add(s);
            }
        }
        return students;
    }

    public Student readById(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("description"),
                    rs.getDate("date_of_birth").toLocalDate(),
                    rs.getTimestamp("updated_at").toLocalDateTime()
                );
            }
        }
        return null;
    }

    public void update(Student student) throws SQLException {
        String sql = "UPDATE students SET name=?, email=?, description=?, date_of_birth=?, updated_at=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getDescription());
            stmt.setDate(4, Date.valueOf(student.getDateOfBirth()));
            stmt.setTimestamp(5, Timestamp.valueOf(student.getUpdatedAt()));
            stmt.setInt(6, student.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}


