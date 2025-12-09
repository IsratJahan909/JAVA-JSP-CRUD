/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abc.jsp_crud.repository;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/practice?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root"; 
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver not found", e);
        }
    }
    
//     private static final String URL = "jdbc:postgresql://localhost:5432/sms";
//    private static final String USER = "postgres";   // your PostgreSQL username
//    private static final String PASS = "root";   // your PostgreSQL password
//
//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("PostgreSQL JDBC Driver not found", e);
//        }
//    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
