package src;

import java.util.ArrayList;
import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;

class Order {

    ArrayList<FoodItem> cart = new ArrayList<>();
    int orderId;

    public Order() {
        Random r = new Random();
        orderId = 1000 + r.nextInt(9000);
    }

    public void addItem(FoodItem item) {
        cart.add(item);
        System.out.println(item.getName() + " added!");
    }

    public void removeItem(int id) {
        for (FoodItem item : cart) {
            if (item.getId() == id) {
                cart.remove(item);
                System.out.println(item.getName() + " removed!");
                return;
            }
        }
        System.out.println("Item not found!");
    }

    public void showCart() {
        System.out.println("\n----- CART -----");

        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        for (FoodItem item : cart) {
            System.out.println(item.getName() + " - Rs." + item.getPrice());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (FoodItem item : cart) {
            total += item.getPrice();
        }
        return total;
    }

    public void saveOrderToDB(Customer c, double finalAmount) {
        try {
            Connection con = DBConnection.getConnection();

            StringBuilder itemsList = new StringBuilder();
            for (FoodItem item : cart) {
                itemsList.append(item.getName())
                        .append(" (").append(item.getPrice()).append("), ");
            }

            String query = "INSERT INTO orders (order_id, customer_name, phone, address, items, total) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.setString(2, c.getName());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getAddress());
            ps.setString(5, itemsList.toString());
            ps.setDouble(6, finalAmount);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("DB Error");
        }
    }

    public void trackOrder() {
        try {
            System.out.println("\nOrder Confirmed...");
            Thread.sleep(1500);
            System.out.println("Preparing Food...");
            Thread.sleep(2000);
            System.out.println("Out for Delivery...");
            Thread.sleep(2000);
            System.out.println("Delivered to your address!");
        } catch (Exception e) {}
    }

    public void orderSummary(Customer c) {

        if (cart.isEmpty()) {
            System.out.println("No items ordered!");
            return;
        }

        System.out.println("\n----- ORDER SUMMARY -----");
        System.out.println("Order ID: " + orderId);
        System.out.println("Name: " + c.getName());
        System.out.println("Address: " + c.getAddress());

        for (FoodItem item : cart) {
            System.out.println(item.getName() + " - Rs." + item.getPrice());
        }

        double total = calculateTotal();
        double finalAmount = c.getDiscount(total);

        System.out.println("Total: Rs." + total);
        System.out.println("After Discount: Rs." + finalAmount);

        saveOrderToDB(c, finalAmount);
        trackOrder();
    }
}