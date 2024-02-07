package org.xemacscode.demo;

import java.sql.*;

public class DBConnection {
   
    static final String DB_URL = "jdbc:mysql://localhost/demo";
    static final String USER = "root";
    static final String PASS = "";

    public static Connection connectDB() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            return conn;
        } catch (Exception ex) {
            System.out.println("Ther were errors while connecting to db");
            return null;
        }
    }
}
