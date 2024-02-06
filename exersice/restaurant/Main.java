package mlc.oop.inheritance.exersice.restaurant;


import mlc.oop.inheritance.exersice.restaurant.beverage.Coffee;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("Lavazza", 1.2);

        System.out.println(coffee.getName());
        System.out.println(coffee.getPrice());
        System.out.println(coffee.getCaffeine());
        System.out.println(coffee.getMilliliters());
    }
}
