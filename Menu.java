package src;

import java.util.ArrayList;

class Menu {
    ArrayList<FoodItem> items = new ArrayList<>();

    public Menu() {

        // Veg
        items.add(new FoodItem(1, "Margherita Pizza", 150));
        items.add(new FoodItem(2, "Veg Burger", 120));
        items.add(new FoodItem(3, "Paneer Roll", 130));

        // Fast Food
        items.add(new FoodItem(4, "French Fries", 90));
        items.add(new FoodItem(5, "Cheese Sandwich", 110));

        // Non-Veg
        items.add(new FoodItem(6, "Chicken Burger", 180));
        items.add(new FoodItem(7, "Chicken Poppers", 250));
        items.add(new FoodItem(8, "Chicken Biryani", 220));
        items.add(new FoodItem(9, "Chicken Puff", 120));

        // Drinks
        items.add(new FoodItem(10, "Coke", 40));
        items.add(new FoodItem(11, "Cold Coffee", 80));
        items.add(new FoodItem(12, "Lassi", 60));
    }

    public void showMenu() {
        System.out.println("\n----- MENU -----");

        System.out.println("\n--- Veg ---");
        for (FoodItem item : items) {
            if (item.getId() >= 1 && item.getId() <= 3)
                System.out.println(item.getId() + ". " + item.getName() + " - Rs." + item.getPrice());
        }

        System.out.println("\n--- Fast Food ---");
        for (FoodItem item : items) {
            if (item.getId() >= 4 && item.getId() <= 5)
                System.out.println(item.getId() + ". " + item.getName() + " - Rs." + item.getPrice());
        }

        System.out.println("\n--- Non-Veg ---");
        for (FoodItem item : items) {
            if (item.getId() >= 6 && item.getId() <= 9)
                System.out.println(item.getId() + ". " + item.getName() + " - Rs." + item.getPrice());
        }

        System.out.println("\n--- Drinks ---");
        for (FoodItem item : items) {
            if (item.getId() >= 10)
                System.out.println(item.getId() + ". " + item.getName() + " - Rs." + item.getPrice());
        }
    }

    public FoodItem getItemById(int id) {
        for (FoodItem item : items) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    public void suggestItems(double budget) {
        System.out.println("\nItems within your budget (Rs." + budget + "):");

        for (FoodItem item : items) {
            if (item.getPrice() <= budget) {
                System.out.println(item.getName() + " - Rs." + item.getPrice());
            }
        }
    }

    public void suggestCombo(double budget) {
        System.out.println("\nCombo offers within Rs." + budget + ":");

        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                double total = items.get(i).getPrice() + items.get(j).getPrice();

                if (total <= budget) {
                    System.out.println(items.get(i).getName() + " + " +
                            items.get(j).getName() + " = Rs." + total);
                }
            }
        }
    }
}