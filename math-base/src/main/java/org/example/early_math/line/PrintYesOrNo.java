package org.example.early_math.line;

import java.util.Scanner;

public class PrintYesOrNo {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            short n = scanner.nextShort();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            short x = scanner.nextShort();

            printYesOrNo(arr,x);
        }
    }

    private static void printYesOrNo(int[] arr, short x) {
        for (int i : arr) {
            if (i == x) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
