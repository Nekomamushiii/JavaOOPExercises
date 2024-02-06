package mlc.advanced.stacksandqueue.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParantheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Character> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        if (input.charAt(0) == '}' || input.charAt(0) == ')' || input.charAt(0) == ']')
            System.out.print("NO");
        else {
            for (Character ch : input.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{')
                    stack.push(ch);
                else if (ch == ')' && (stack.isEmpty() || stack.peek() != '(')) {
                    System.out.print("NO");
                    return;
                }
                else if (ch == ')' && stack.peek() == '(')
                    stack.pop();
                else if (ch == ']' && (stack.isEmpty() || stack.peek() != '[')) {
                    System.out.print("NO");
                    return;
                }
                else if (ch == ']' && stack.peek() == '[')
                    stack.pop();
                else if (ch == '}' && (stack.isEmpty() || stack.peek() != '{')) {
                    System.out.print("NO");
                    return;
                }
                else if (ch == '}' && stack.peek() == '{')
                    stack.pop();
            }
            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
    }
}
