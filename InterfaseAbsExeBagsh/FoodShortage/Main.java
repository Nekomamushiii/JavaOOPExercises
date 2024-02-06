package mlc.oop.int_abs.exercise.FoodShortage;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Person, List<Buyer>> buyers = new LinkedHashMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        while (count-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person;
            Buyer buyer;

            if (data.length == 4) {
                String id = data[2];
                String birthDate = data[3];
                person = new Citizen(name, age, id, birthDate);
                buyer = new Citizen(name, age, id, birthDate);
            } else {
                String group = data[2];
                person = new Rebel(name, age, group);
                buyer = new Rebel(name, age, group);
            }

            buyers.putIfAbsent(person, new ArrayList<>());
            buyers.get(person).add(buyer);
        }

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            final String name = input;
            buyers.entrySet().stream()
                    .filter(e -> e.getKey().getName().equals(name))
                    .forEach(e -> e.getValue().forEach(Buyer::buyFood));
        }

        int sum = 0;
        for (Map.Entry<Person, List<Buyer>> personListEntry : buyers.entrySet()) {
            sum += personListEntry.getValue().stream()
                    .map(Buyer::getFood)
                    .mapToInt(Integer::intValue)
                    .sum();
        }

        System.out.println(sum);
    }
}