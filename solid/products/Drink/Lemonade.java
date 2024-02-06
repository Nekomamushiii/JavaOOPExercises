package solid.products.Drink;

import solid.products.Product;

public class Lemonade extends BaseDrink {
    private static final double CALORIES_PER_100_GRAMS=150.0;
    private static final double DENSITY=30.0;
    public Lemonade(double milliliters) {
        super(milliliters, CALORIES_PER_100_GRAMS, DENSITY);
    }
}
