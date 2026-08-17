package food.model;

/**
 * Abstract base class representing a generic food order.
 * Holds common order data and enforces delivery-charge calculation
 * on every subclass via an abstract method.
 */
public abstract class FoodOrder {

    // ---- private instance data ----
    private int orderId;
    private String customerName;
    private double amount;

    // ---- static members ----
    public static String restaurantName;
    private static int orderCounter = 0;

    // ---- constructor ----
    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        orderCounter++;               // every new order increments the counter
    }

    // ---- getters / setters ----
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static String getRestaurantName() {
        return restaurantName;
    }

    public static void setRestaurantName(String name) {
        restaurantName = name;
    }

    // ---- abstract method: every subclass must define its own delivery charge ----
    public abstract double calculateDeliveryCharge();

    // ---- static method reporting total orders created so far ----
    public static void displayTotalOrders() {
        System.out.println("Total Orders Placed: " + orderCounter);
    }
}
