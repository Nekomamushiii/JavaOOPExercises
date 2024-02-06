package solid.products.Drink;

public class BaseDrink implements Drink {
    private final double milliliters;
    private final double caloriesPer100Grams;
    private final double density;

    protected BaseDrink(double milliliters, double caloriesPer100Grams, double density) {
        this.milliliters = milliliters;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.density = density;
    }
    private double caloriesCalculate(){
        double grams=this.milliliters*this.density;
        return this.caloriesPer100Grams/100*grams;
    }

    @Override
    public double getCalories() {
        return caloriesCalculate();
    }
}
