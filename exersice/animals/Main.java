package mlc.oop.inheritance.exersice.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while(true) {
            String type = scanner.nextLine();
            if(type.equals("Beast!"))
                break;
            String[] input = scanner.nextLine().split(" ");
            int age = Integer.parseInt(input[1]);
            if(age < 0) {
                System.out.println("Invalid input!");
                continue;
            }
            switch (type) {
                case "Dog":
                    Dog dog = new Dog(input[0], Integer.parseInt(input[1]), input[2]);
                    System.out.println(dog);
                    break;
                case "Frog":
                    Frog frog = new Frog(input[0], Integer.parseInt(input[1]), input[2]);
                    System.out.println(frog);
                    break;
                case "Cat":
                    Cat cat = new Cat(input[0], Integer.parseInt(input[1]), input[2]);
                    System.out.println(cat);
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(input[0], Integer.parseInt(input[1]));
                    System.out.println(tomcat);
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(input[0], Integer.parseInt(input[1]));
                    System.out.println(kitten);
                    break;
                default: break;
            }
        }
    }
}
