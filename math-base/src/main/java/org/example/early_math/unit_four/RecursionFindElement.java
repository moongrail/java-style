package org.example.early_math.unit_four;

import java.util.stream.IntStream;

public class RecursionFindElement {
    public static void main(String[] args) {
        int[] array = IntStream.iterate(0, i -> i + 2)
                .limit(30)
                .toArray();

        printKeyNumber(array, 22);
    }

    private static void printKeyNumber(int[] array, int key) {
        int resultIndex = findKeyIndex(array, key);
        if (resultIndex != -1) {
            int resultNumber = array[resultIndex];
            System.out.println("Index " + resultIndex + ", Number = " + resultNumber);
        } else {
            System.out.println("Not found.");
        }
    }

    private static int findKeyIndex(int[] array, int key) {
        return findIndexRecursive(array, key, 0);
    }

    private static int findIndexRecursive(int[] array, int key, int startIndex) {
        if (startIndex >= array.length) return -1;

        if (array[startIndex] == key) return startIndex;

        return findIndexRecursive(array, key, startIndex + 1);
    }
}
