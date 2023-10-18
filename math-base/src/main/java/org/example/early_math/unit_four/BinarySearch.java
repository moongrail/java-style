package org.example.early_math.unit_four;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arrayToTest = IntStream.iterate(0, i -> i + 1)
                .limit(30)
                .toArray();
        System.out.println(Arrays.toString(arrayToTest));
        System.out.println(binarySearch(arrayToTest, 11));
    }

    private static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int midIndex = (low + high) / 2;
            int midValue = array[midIndex];

            if (midValue == value) {
                return midIndex;
            }

            if (midValue > value) {
                high = midIndex - 1;
            } else {
                low = midIndex + 1;
            }
        }

        return -1;
    }
}
