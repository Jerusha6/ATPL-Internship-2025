package com.aaslin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://192.168.71.15:3306/intern";
    private static final String username = "intern2025";
    private static final String password = "intern2025";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            throw new SQLException("JDBC Driver not found", e);
        }
    }
}
