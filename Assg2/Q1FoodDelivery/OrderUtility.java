package food.utility;

import food.model.Discountable;
import food.model.FoodOrder;

/**
 * Utility methods for validating order data and printing a formatted
 * order summary (bill, delivery charge, discount, final payable amount).
 */
public class OrderUtility {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static String generateOrderSummary(FoodOrder order) {
        double deliveryCharge = order.calculateDeliveryCharge();

        // Discount only applies if this particular order type implements Discountable
        double discount = 0.0;
        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }

        double finalAmount = order.getAmount() - discount + deliveryCharge;

        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------\n");
        sb.append("Order ID        : ").append(order.getOrderId()).append("\n");
        sb.append("Customer Name   : ").append(order.getCustomerName()).append("\n");
        sb.append("Order Type      : ").append(order.getClass().getSimpleName()).append("\n");
        sb.append(String.format("Bill Amount     : Rs. %.2f%n", order.getAmount()));
        sb.append(String.format("Delivery Charge : Rs. %.2f%n", deliveryCharge));
        sb.append(String.format("Discount        : Rs. %.2f%n", discount));
        sb.append(String.format("Final Payable   : Rs. %.2f%n", finalAmount));
        sb.append("-----------------------------------------");
        return sb.toString();
    }
}
