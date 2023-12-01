package org.example.early_math.line;

import java.util.Scanner;

public class PrintCountX {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            short n = scanner.nextShort();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            short x = scanner.nextShort();

            countXInArray(arr,x);
        }
    }

    private static void countXInArray(int[] arr, short x) {
        int count = 0;

        for (int i : arr) {
            if (i == x) {
                count++;
            }
        }

        System.out.println(count);
    }
}
