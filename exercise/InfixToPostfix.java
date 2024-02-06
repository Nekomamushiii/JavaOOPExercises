package mlc.advanced.stacksandqueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> operators = new ArrayDeque<>();
        Deque<String> output = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s")).forEach(
                element -> {
                    if (element.equals("+") || element.equals("-")) {
                        if(!operators.isEmpty() && !operators.peek().equals("("))
                            output.offer(operators.pop());
                        operators.push(element);
                    } else if (element.equals("*") || element.equals("/")) {
                        if(!operators.isEmpty() && !operators.peek().equals("+") && !operators.peek().equals("-")
                            && !operators.peek().equals("("))
                            output.offer(operators.pop());
                        operators.push(element);
                    } else if (element.equals("("))
                        operators.push(element);
                    else if (element.equals(")")) {
                        String prevOperator = operators.peek();
                        while (!prevOperator.equals("(")) {
                            output.add(operators.pop());
                            prevOperator = operators.peek();
                        }
                        operators.pop();
                    } else
                        output.add(element);
                }
        );
        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }
        while(!output.isEmpty())
            System.out.print(output.poll()+ " ");
    }
}
