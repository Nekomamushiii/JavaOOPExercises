package mlc.oop.inheritance.exersice.needForSpeed;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car(10, 100);

        System.out.println(vehicle.getFuel());
        System.out.println(vehicle.getFuelConsumption());
        System.out.println(vehicle.getHorsePower());

        vehicle.drive(4);

        System.out.println();
        System.out.println("Fuel: " + vehicle.getFuel());
        System.out.println(vehicle.getFuelConsumption());
        System.out.println(vehicle.getHorsePower());
    }
}
