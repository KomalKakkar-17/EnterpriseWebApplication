package food.model;

/**
 * Contract for any order type that supports a discount.
 */
public interface Discountable {
    double applyDiscount();
}
