package solid.products.Food;

import solid.products.Product;

public class Chocolate extends BaseFood {
   private static final double CALORIES_PER_100_GRAMS=100.0;

    public Chocolate(double grams) {
        super(grams, CALORIES_PER_100_GRAMS);
    }
}
