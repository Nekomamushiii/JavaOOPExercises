package mlc.advanced.examprep1;

import java.util.*;

public class OsPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> tasks = new ArrayDeque<>();
        Deque<Integer> threads = new ArrayDeque<>();
        int killTask = 0;

        Arrays.stream(scanner.nextLine().split(", "))
                .forEach(task -> tasks.push(Integer.parseInt(task)));
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(thread -> threads.offer(Integer.parseInt(thread)));
        killTask = Integer.parseInt(scanner.nextLine());

        int task = tasks.peek();
        int thread = 0;
        while(task != killTask) {
            thread = threads.poll();
            if(thread >= task) {
                tasks.pop();
                task = tasks.peek();
            }
        }
        thread = threads.poll();
        System.out.printf("Thread with value %d killed task %d%n", thread, task);
        System.out.print(thread);
        while(!threads.isEmpty())
            System.out.print(" " + threads.poll());
    }
}
