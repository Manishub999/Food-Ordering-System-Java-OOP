package src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class ViewOrders {
    public static void showOrders() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM orders");

            System.out.println("\n----- ALL ORDERS -----");

            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("order_id"));
                System.out.println("Customer: " + rs.getString("customer_name"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Items: " + rs.getString("items"));
                System.out.println("Total: Rs." + rs.getDouble("total"));
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            System.out.println("Error fetching orders");
        }
    }
}