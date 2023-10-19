package org.example.early_math.unit_four;

import java.util.stream.IntStream;

public class SumArrayRecursive {
    public static void main(String[] args) {
        int[] array = IntStream.iterate(0, i -> i + 1)
                .limit(4)
                .toArray();
        System.out.println(sumArrayRecursive(array, 0));
    }

    private static int sumArrayRecursive(int[] array, int startIndex) {
        int sum = 0;

        if (array.length == 0) return sum;
        if (startIndex >= array.length) return sum;

        sum += sumArrayRecursive(array, startIndex + 1);
        sum += array[startIndex];

        return sum;
    }
}
