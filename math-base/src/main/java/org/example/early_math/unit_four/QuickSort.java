package org.example.early_math.unit_four;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array ={33,11,3,5,22,1213,55,44,677};
        System.out.println(Arrays.toString(quickSort(array, 0, array.length - 1)));
    }

    private static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }

        return array;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private static int partitionFromMiddle(int arr[], int low, int hight) {
        int i = low;
        int j = hight;
        int pivot = arr[low + (hight - low) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
}