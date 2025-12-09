package com.israt.employees_database.repository;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/student"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "root"; 

    private static Connection connection = null;

   
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
        }
    }

        
    public static Connection getConnection() {
        return connection;
    }
}


