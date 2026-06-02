package src;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== FOODHUB : ONLINE FOOD ORDERING SYSTEM =====");

        
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        
        Customer customer = new Customer(name, phone, address);

        Menu menu = new Menu();
        Order order = new Order();

        int choice;

        do {
            System.out.println("\n1. Show Menu");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. View Cart");
            System.out.println("5. Get Suggestions (Budget)");
            System.out.println("6. Checkout");
            System.out.println("7. View Orders (Admin)");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    menu.showMenu();
                    break;

                case 2:
                    System.out.print("Enter item id: ");
                    FoodItem item = menu.getItemById(sc.nextInt());
                    if (item != null) {
                        order.addItem(item);
                    } else {
                        System.out.println("Invalid item!");
                    }
                    break;

                case 3:
                    System.out.print("Enter item id: ");
                    order.removeItem(sc.nextInt());
                    break;

                case 4:
                    order.showCart();
                    break;

                case 5:
                    System.out.print("Enter your budget: ");
                    double budget = sc.nextDouble();
                    menu.suggestItems(budget);
                    menu.suggestCombo(budget);
                    break;

                case 6:
                    sc.nextLine(); 

                    
                    System.out.print("Are you premium customer? (yes/no): ");
                    String type = sc.nextLine();

                    if (type.equalsIgnoreCase("yes")) {
                        customer = new PremiumCustomer(name, phone, address);
                    }

                    order.orderSummary(customer);
                    break;

                case 7:
                    sc.nextLine(); 

                    System.out.print("Enter admin username: ");
                    String user = sc.nextLine();

                    System.out.print("Enter password: ");
                    String pass = sc.nextLine();

                    if (user.equals("admin") && pass.equals("1234")) {
                        ViewOrders.showOrders();
                    } else {
                        System.out.println("Access Denied!");
                    }
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}