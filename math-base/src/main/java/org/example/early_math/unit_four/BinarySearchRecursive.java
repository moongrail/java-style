package org.example.early_math.unit_four;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] array = IntStream.iterate(1, i -> i + 1).limit(4).toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(binarySearchRecursive(array, 0, array.length, 4));
    }

    private static int binarySearchRecursive(int[] array, int low, int high, int value) {
        if (array.length == 0) return -1;
        if (low >= high) return -1;

        int midIndex = (low + high) / 2;
        int guess = array[midIndex];

        if (guess == value) {
            return midIndex;
        } else if (guess > value) {
            return binarySearchRecursive(array, low, midIndex - 1, value);
        } else {
            return binarySearchRecursive(array, midIndex + 1, high, value);
        }
    }
}
