package solid;

import solid.calculators.Calculator;
import solid.calculators.CalorieCalculator;
import solid.print.Printer;
import solid.products.Food.Chocolate;
import solid.products.Drink.Coke;
import solid.products.Drink.Lemonade;
import solid.products.Product;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product chocolate=new Chocolate(100);
        Product coke= new Coke(50);
        Product lemonade=new Lemonade(50);
        List<Product> products = List.of(chocolate,coke,lemonade);
        Calculator calculator =new CalorieCalculator();
        Printer printer=new Printer(calculator);
        printer.printSum(products);
        printer.printAverage(products);
    }
}
