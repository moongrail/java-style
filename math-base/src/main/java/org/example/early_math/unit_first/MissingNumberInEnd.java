package org.example.early_math.unit_first;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumberInEnd {
    public static void main(String[] args) {
        int[] arrayToTest = getArrayToTest(1);
        printAndAddMissingNumber(arrayToTest);
    }

    //Не совсем совершенный алгоритм, работает только если неправильный элемент лежит в конце массива
    //и положительный.
    private static void printAndAddMissingNumber(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int previous = array[i];
            int next = array[i + 1];
            int difference = next - previous;

            if (difference > 1) {
                System.out.printf("Find previous = %d, next = %d, difference = %d\n", previous, next, difference);

                array[i + 1] = next - difference;
                int[] result = new int[array.length + difference];
                System.arraycopy(array, 0, result, 0, array.length);

                for (int j = difference; j > 0; j--) {
                    result[result.length - j] = next - j + 1;
                }

                System.out.println(Arrays.toString(result));
            }
        }
    }

    private static int[] getArrayToTest(int increment) {
        int[] array = IntStream.iterate(0, i -> i + increment)
                .limit(101)
                .toArray();
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[100] = 150;
        return newArray;
    }
}
