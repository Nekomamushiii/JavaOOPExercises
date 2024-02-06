package pizzaCalories;

public class Topping {
    private static final double BASE_CALORIES = 2;
    private static final String TYPE_MEAT = "Meat";
    private static final String TYPE_VEGGIES = "Veggies";
    private static final String TYPE_CHEESE = "Cheese";
    private static final String TYPE_SAUCE = "Sauce";
    private static final double TYPE_MEAT_VAL = 1.2;
    private static final double TYPE_VEGGIES_VAL = 0.8;
    private static final double TYPE_CHEESE_VAL = 1.1;
    private static final double TYPE_SAUCE_VAL = 0.9;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public double calculateCalories() {
        double calories = BASE_CALORIES * this.weight * getModifierValue(this.toppingType);

        return calories;
    }

    private void setToppingType(String toppingType) {
        validateToppingType(toppingType);

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }

        this.weight = weight;
    }

    private void validateToppingType(String toppingType) {
        boolean isValid = toppingType.equals(TYPE_MEAT) ||
                toppingType.equals(TYPE_VEGGIES) ||
                toppingType.equals(TYPE_CHEESE) ||
                toppingType.equals(TYPE_SAUCE);

        if (!isValid) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private double getModifierValue(String modifier) {
        double modifierVal = 0;

        switch (modifier) {
            case TYPE_MEAT:
                modifierVal = TYPE_MEAT_VAL;
                break;
            case TYPE_VEGGIES:
                modifierVal = TYPE_VEGGIES_VAL;
                break;
            case TYPE_CHEESE:
                modifierVal = TYPE_CHEESE_VAL;
                break;
            case TYPE_SAUCE:
                modifierVal = TYPE_SAUCE_VAL;
                break;
        }

        return modifierVal;
    }
}
