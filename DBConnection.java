package src;

import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/food_order_db";
            String user = "root";
            String pass = "m@ni9k@p@di5"; 

            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("DB Connection Failed");
            return null;
        }
    }
}