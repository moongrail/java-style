package org.example.early_math.unit_four;

public class FindMaxRecursive {
    public static void main(String[] args) {
        int[] array = {3, 55, 111, 1, 444, 5};
        System.out.println(findMaxRecursive(array, 0));
    }

    private static int findMaxRecursive(int[] array, int index) {
        if (array.length == 0) return 0;
        if (index >= array.length) return 0;

        int max = findMaxRecursive(array, index + 1);

        if (array[index] > max) max = array[index];

        return max;
    }
}
