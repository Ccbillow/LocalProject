package org.example.interview.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{19, 28, 8, 23, 10, 21, 9};
        System.out.println("before sort, arr:" + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("after sort, arr:" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        int index = partition(arr, low, high);
        quickSort(arr, 0, index - 1);
        quickSort(arr, index+1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int base = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= base) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= base) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = base;
        return low;
    }

    private static int partition2(int[] arr, int low, int high) {
        int base = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= base) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= base) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = base;
        return low;
    }
}
