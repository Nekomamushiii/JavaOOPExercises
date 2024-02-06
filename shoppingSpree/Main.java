package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        Map<String, Person> people = new LinkedHashMap<>();
//        Map<String, Product> products = new HashMap<>();
//
//        try {
//            Arrays.stream(reader.readLine().split(";"))
//                    .forEach(p -> {
//                        String[] tokens = p.split("=");
//                        Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
//                        people.putIfAbsent(tokens[0], person);
//                    });
//
//
//            Arrays.stream(reader.readLine().split(";"))
//                    .forEach(p -> {
//                        String[] tokens = p.split("=");
//                        Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
//                        products.putIfAbsent(tokens[0], product);
//                    });
//        } catch (IllegalArgumentException iae) {
//            System.out.println(iae.getMessage());
//            return;
//        }
//
//        String line;
//        while (true) {
//            if ("END".equals(line = reader.readLine())) {
//                break;
//            }
//
//            String[] tokens = line.split("\\s+");
//
//            String personName = tokens[0];
//            String productName = tokens[1];
//
//            Person person = people.get(personName);
//            Product product = products.get(productName);
//
//            if (person == null || product == null) {
//                continue;
//            }
//
//            try {
//                person.buyProduct(product);
//                System.out.println(String.format("%s bought %s", person.getName(), product.getName()));
//            } catch (IllegalStateException ise) {
//                System.out.println(ise.getMessage());
//            }
//        }
//
//        people.values().forEach(p -> {
//            StringBuilder result = new StringBuilder();
//            if (p.getProducts().size() == 0) {
//                result.append(String.format("%s - Nothing bought", p.getName()));
//            } else {
//                result.append(String.format("%s - %s", p.getName(), p.getProducts().stream().map(Product::getName).collect(Collectors.joining(", "))));
//            }
//
//            System.out.println(result.toString());
//        });
    }
}
