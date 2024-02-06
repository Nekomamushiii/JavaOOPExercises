import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers {

    private static int lower = 1;
    private static final int END = 100;
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        while (numbers.size() < 10) {
            try {
                readNumber(lower, END);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String output = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);
    }

    private static void readNumber(int start, int end) throws Exception {
        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            if (number <= start || number >= end) {
                System.out.printf("Your number is not in range %d - %d!%n", lower, end);
            } else {
                lower = number;
                numbers.add(number);
            }
        } catch (Exception e) {
            throw new Exception("Invalid Number!");
        }
    }
}
