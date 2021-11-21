/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DAO {
     public static Connection connection = null;

    public DAO() {
        String dbUrl =
                "jdbc:mysql://localhost:3306/pttk_bookstore?autoReconnect=true&useSSL=false";
        String dbClass = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(dbClass);
            connection = DriverManager.getConnection(dbUrl, "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
