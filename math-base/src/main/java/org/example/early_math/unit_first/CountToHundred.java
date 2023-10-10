package org.example.early_math.unit_first;

public class CountToHundred {
    public static void main(String[] args) {
        printHundredNumbers();
    }

    public static void printHundredNumbers() {
        byte[] baseInts = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < baseInts.length; i++) {
            for (byte baseInt : baseInts) {
                System.out.printf("%d%d ", baseInts[i], baseInt);
            }
            System.out.println();
        }
    }
}
