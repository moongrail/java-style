package org.example.early_math.unit_four;

import java.util.stream.IntStream;

public class SumArrays {
    public static void main(String[] args) {
        int[] arrayFirst = {1, 2, 3, 4, 5};
        int[] arraySecond = {1, 2, 3, 4, 5, 6, 7};
        int[] arrayThird = {1, 2, 3, 4, 5};

        System.out.println(sumDigitInArrays(arrayFirst, arraySecond, arrayThird));
    }

    private static int sumDigitInArrays(int[]... arrays) {
        int result = 0;

        for (int[] array : arrays) {
            result += IntStream.of(array)
                    .sum();
        }

        return result;
    }
}
