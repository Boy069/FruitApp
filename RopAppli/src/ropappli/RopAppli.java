package ropappli;

import java.sql.*;

public class RopAppli {

    public static Connection connectDB() {

        String db_Name = "ropappli";
        String user = "root";
        String pass = "";
        String hostName = "localhost";
        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverName);
            String url = "jdbc:mysql://" + hostName + "/" + db_Name;
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("connected complete");
            return con;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        new RopAppli().connectDB();
    }

}
