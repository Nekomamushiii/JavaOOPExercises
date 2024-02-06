package solid.products.Food;

import solid.products.Product;

public class Chips extends BaseFood{
    private static final double CALORIES_PER_100_GRAMS=500.0;

    public Chips(double grams) {
        super(grams, CALORIES_PER_100_GRAMS);
    }
}
