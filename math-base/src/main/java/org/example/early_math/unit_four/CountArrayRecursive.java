package org.example.early_math.unit_four;

import java.util.stream.IntStream;

public class CountArrayRecursive {
    public static void main(String[] args) {
        int[] array = IntStream.iterate(0, i -> i + 1).limit(50).toArray();
        System.out.println(countElementsRecursive(array,0));
    }

    private static int countElementsRecursive(int [] array, int index){
        if (array.length == 0) return 0;
        if (index >= array.length) return 0;

        int count = countElementsRecursive(array, index+1);
        count++;

        return count;
    }
}
