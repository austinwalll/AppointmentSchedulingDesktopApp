package com.example.c195_wallace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public static Connection conn = null;

    public static Connection establishConnection() {
        String url = "jdbc:mysql://localhost:3306/client_schedule";
        String user = "sqlUser";
        String password = "Passw0rd!";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
            conn = connection;
            return connection;

        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            return null;
        }
    }

    public static void endConnection(Connection connection) {
        try {

            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection: " + e.getMessage());
        }
    }

    public static Connection getConnection(){
        return conn;
    }
}
