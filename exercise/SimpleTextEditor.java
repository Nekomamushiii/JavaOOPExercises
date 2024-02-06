package mlc.advanced.stacksandqueue.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Deque<String> stack = new ArrayDeque<>();
        String current = "";
        for(;n > 0 ; n--) {
            String[] arr = scanner.nextLine().split("\\s");
            switch (arr[0]) {
                case "1":
                    current += arr[1];
                    stack.push(current);
                    break;
                case "2":
                    current = current.substring(0, current.length() - Integer.parseInt(arr[1]));
                    stack.push(current);
                    break;
                case "3":
                    System.out.println(current.charAt(Integer.parseInt(arr[1]) - 1));
                    break;
                case "4":
                    stack.pop();
                    current = stack.peek();
                    break;
            }
        }
    }
}
