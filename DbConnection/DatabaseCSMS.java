package DbConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCSMS {
    private static final String URL = "jdbc:mysql://localhost:3306/carshowroommanagementsystem"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 
    public static Connection getConnection() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
        return conn;
    }
}
