package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.utility.OrderUtility;

/**
 * Driver class: creates orders, stores them polymorphically in a
 * FoodOrder[] array, validates them, and prints each order's bill.
 */
public class Main {
    public static void main(String[] args) {

        FoodOrder.setRestaurantName("Tasty Bites Restaurant");

        // i & ii: create at least six orders, stored as an array of the base type
        FoodOrder[] orders = new FoodOrder[6];
        orders[0] = new RegularOrder(101, "Aarav Sharma", 500);
        orders[1] = new PremiumOrder(102, "Priya Singh", 1200);
        orders[2] = new RegularOrder(103, "Rohan Mehta", 350);
        orders[3] = new PremiumOrder(104, "Sneha Kapoor", 900);
        orders[4] = new RegularOrder(105, "Vikram Rao", 620);
        orders[5] = new PremiumOrder(106, "Ananya Das", 1500);

        System.out.println("Restaurant: " + FoodOrder.getRestaurantName());
        System.out.println();

        // iii-vi: display bill, discount, delivery charge, final payable amount
        for (FoodOrder order : orders) {
            if (!OrderUtility.validateAmount(order.getAmount())) {
                System.out.println("Skipping order " + order.getOrderId() + ": invalid amount.");
                continue;
            }
            if (!OrderUtility.validateCustomerName(order.getCustomerName())) {
                System.out.println("Skipping order " + order.getOrderId() + ": invalid customer name.");
                continue;
            }
            System.out.println(OrderUtility.generateOrderSummary(order));
        }

        System.out.println();
        FoodOrder.displayTotalOrders();
    }
}
