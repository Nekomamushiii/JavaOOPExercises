package mlc.advanced.stacksandqueue.exercise;

import java.util.*;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(
                element -> stack.push(Integer.parseInt(element))
        );
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
