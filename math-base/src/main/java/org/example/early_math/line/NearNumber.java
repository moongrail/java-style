package org.example.early_math.line;

import java.util.Scanner;

public class NearNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            short n = scanner.nextShort();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            short x = scanner.nextShort();

            findNearNumber(arr, x);
        }
    }

    private static void findNearNumber(int[] arr, short x) {
        int near = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < Math.abs(near - x)) {
                near = arr[i];
            }
        }

        System.out.println(near + "\n");
    }
}
