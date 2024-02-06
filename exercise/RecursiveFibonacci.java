package mlc.advanced.stacksandqueue.exercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        memory = new long[n + 1];
        System.out.println(fin(n));
    }

    private static long fin(int n)  {
        if(n < 2){
            return 1;
        }
        if(memory[n] != 0){
            return memory[n];
        }
        return memory[n] = fin(n - 1) + fin(n - 2);
    }
}
