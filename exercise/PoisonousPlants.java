package mlc.advanced.stacksandqueue.exercise;

import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantsCount = Integer.parseInt(scanner.nextLine());
        Deque<Integer> plants = new ArrayDeque<>();
        for (String plant : scanner.nextLine().split("\\s")) {
            plants.offer(Integer.parseInt(plant));
        }
        boolean anyDead = true;
        int cycleCount = 0;
        while (anyDead) {
            Integer previous = null;
            anyDead = false;
            Deque<Integer> sub = new ArrayDeque<>();
            while (!plants.isEmpty()) {
                Integer current = plants.poll();
                if (previous == null)
                    sub.add(current);
                else {
                    if (previous >= current) {
                        sub.add(current);
                    } else
                        anyDead = true;
                }
                previous = current;
            }
            plants = sub;
            cycleCount++;
        }
        System.out.println(cycleCount - 1);
    }
}
