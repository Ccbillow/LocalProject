package org.example.auz.quicksort;

import java.util.Arrays;

/**
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {5, 6, 4, 3, 78, 213, 45, 67, 32};
        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }

        int base = partition(arr, low, high);
        quickSort(arr, 0, base - 1);
        quickSort(arr, base + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int base = arr[low];
        while (low < high) {
            while (low < high && base <= arr[high]) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && base >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = base;
        return low;
    }
}
