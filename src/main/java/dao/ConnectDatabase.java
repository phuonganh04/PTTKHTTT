package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private Connection conn;
    private String jdbcURL = "jdbc:mysql://localhost:3306/shop";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thai0211";
    private static ConnectDatabase connectDatabase = null;
    
    private ConnectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername,
                    jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ConnectDatabase getInstance(){
        if(connectDatabase == null){
            connectDatabase = new ConnectDatabase();
        }
        return connectDatabase;
    }
    public Connection getConnection(){
        return conn;
    }
}