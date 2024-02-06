package solid.products.Food;

public class BaseFood implements Food{
    private final double grams;
    private final double caloriesPer100Grams;

    protected BaseFood(double grams, double caloriesPer100Grams) {
        this.grams = grams;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }
    private double calculateCalories(){
        return this.caloriesPer100Grams*this.grams;
    }

    @Override
    public double getCalories() {
        return calculateCalories();
    }
}
