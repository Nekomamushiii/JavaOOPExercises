package Exam2;

import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> textiles = parseInput(scan.nextLine());
        List<Integer> medicaments = parseInput(scan.nextLine());
        List<String> createdItems = new ArrayList<>();
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.get(0);
            int medicament = medicaments.get(medicaments.size() - 1);
            int sum = textile + medicament;
            if (sum == 30) {
                createdItems.add("Patch");
                textiles.remove(0);
                medicaments.remove(medicaments.size() - 1);
            } else if (sum == 40) {
                createdItems.add("Bandage");
                textiles.remove(0);
                medicaments.remove(medicaments.size() - 1);
            } else if (sum == 100) {
                createdItems.add("MedKit");
                textiles.remove(0);
                medicaments.remove(medicaments.size() - 1);
            } else if (sum > 100) {
                createdItems.add("MedKit");
                textiles.remove(0);
                medicaments.set(medicaments.size() - 1, medicament + sum - 100);
            } else {
                textiles.remove(0);
                medicaments.set(medicaments.size() - 1, medicament + 10);
            }
        }
        printResult(textiles, medicaments, createdItems);
    }
    private static List<Integer> parseInput(String input) {
        List<Integer> list = new ArrayList<>();
        String[] items = input.split(" ");
        for (String item : items) {
            list.add(Integer.parseInt(item));
        }
        return list;
    }
    private static void printResult(List<Integer> textiles, List<Integer> medicaments, List<String> createdItems) {
        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }
        Collections.sort(createdItems);
        Map<String, Integer> itemCounts = new HashMap<>();
        for (String item : createdItems) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        if (!medicaments.isEmpty()) {
            System.out.print("Medicaments left: ");
            for (int i = 0; i < medicaments.size(); i++) {
                System.out.print(medicaments.get(i));
                if (i < medicaments.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        if (!textiles.isEmpty()) {
            System.out.print("Textiles left: ");
            for (int i = 0; i < textiles.size(); i++) {
                System.out.print(textiles.get(i));
                if (i < textiles.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}