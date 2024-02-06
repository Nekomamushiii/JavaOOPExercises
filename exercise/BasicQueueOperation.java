package mlc.advanced.stacksandqueue.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int X = scanner.nextInt();
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i ++)
            queue.offer(scanner.nextInt());

        if(N <= S)
            System.out.println("0");
        else {
            for(; S > 0; S--)
                queue.poll();
            int min = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                if(current == X)  {
                    min = X;
                    break;
                } else if(current < min)
                    min = current;
            }
            if(min == X)
                System.out.println("true");
            else
                System.out.println(min);
        }
    }
}
