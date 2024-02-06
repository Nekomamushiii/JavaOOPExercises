package solid.products.Drink;

import solid.products.Product;

public class Coke extends BaseDrink {
    private static final double CALORIES_PER_100_GRAMS=500.0;
    private static final double DENSITY=50.0;

    public Coke(double milliliters) {
        super(milliliters, CALORIES_PER_100_GRAMS, DENSITY);
    }
}
