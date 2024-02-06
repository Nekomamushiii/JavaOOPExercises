package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaTokens = reader.readLine().split("\\s+");
        String[] doughTokens = reader.readLine().split("\\s+");

        Pizza pizza = null;

        try {
            int countOfToppings = Integer.parseInt(pizzaTokens[2]);
            pizza = new Pizza(pizzaTokens[1], countOfToppings);
            Dough dough = new Dough(doughTokens[1], doughTokens[2],Double.parseDouble(doughTokens[3]));
            pizza.setDough(dough);

            while (countOfToppings-- > 0) {
                String[] toppingTokens = reader.readLine().split("\\s+");

                Topping topping = new Topping(toppingTokens[1], Double.parseDouble(toppingTokens[2]));

                pizza.addTopping(topping);
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getOverallCalories()));
    }
}
