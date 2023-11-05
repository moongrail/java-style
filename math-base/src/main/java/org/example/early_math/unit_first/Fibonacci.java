package org.example.early_math.unit_first;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getFibonacciArray(41111111)));
//        System.out.println(getFibonacciString(41111111));
//        System.out.println(getFibonacciList(41111111));
        //Вывод -> без рекурсии быстрее с большими числами.
        System.out.println(getFibonacciListNoRecursion(41111111));
    }

    private static int[] getFibonacciArray(int n) {
        if (n == 0) return new int[]{0};
        int[] fibonacciArray = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            int fibonacciResult = fibonacciRecursion(i);

            if (fibonacciResult > n) {
                size = i;
                break;
            }

            fibonacciArray[i] = fibonacciResult;
        }

        int[] fibonacciArrayResult = new int[size];
        System.arraycopy(fibonacciArray, 0, fibonacciArrayResult, 0, size);

        return fibonacciArrayResult;
    }

    private static String getFibonacciString(int n) {
        if (n == 0) return "0";
        StringBuilder arrayString = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int fibonacciValue = fibonacciRecursion(i);

            if (n < fibonacciValue) {
                break;
            }

            arrayString.append(fibonacciValue).append(" ");
        }

        return arrayString.toString();
    }

    private static List<Integer> getFibonacciList(int n) {
        if (n == 0) return List.of(0);

        List<Integer> fibonacciList = new ArrayList<>();
        int fibonacciValue = 0;
        int index = 0;

        while (n > fibonacciValue) {
            fibonacciValue = fibonacciRecursion(index);

            if (n < fibonacciValue) {
                break;
            }
            fibonacciList.add(fibonacciValue);
            index++;
        }

        return fibonacciList;
    }

    private static List<Integer> getFibonacciListNoRecursion(int n) {
        if (n == 0) return List.of(0);

        List<Integer> fibonacciList = new ArrayList<>();
        int fibonacciValue = 0;
        int prevFibonacci = 0;
        int currentFibonacci = 1;

        while (n > fibonacciValue) {
            fibonacciValue = currentFibonacci;

            if (n < fibonacciValue) {
                break;
            }

            fibonacciList.add(fibonacciValue);

            int nextFibonacci = prevFibonacci + currentFibonacci;
            prevFibonacci = currentFibonacci;
            currentFibonacci = nextFibonacci;
        }

        return fibonacciList;
    }

    private static int fibonacciRecursion(int index) {
        if (index <= 1) {
            return index;
        }

        return fibonacciRecursion(index - 1) + fibonacciRecursion(index - 2);
    }
}
