package org.example.interview.sort;

public class Quick {

    public static void quicksort(int[] arr) {

    }

    private static void quick(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int partion = helper(arr, start, end);
        quick(arr, start, partion - 1);
        quick(arr, partion + 1, end);
    }

    private static int helper(int[] arr, int start, int end) {
        int base = arr[start];

        while (start < end) {
            while (start < end && arr[start] <= base) {
                start++;
            }
            arr[end] = arr[start];

            while (start < end && arr[end] >= base) {
                end--;
            }
            arr[start] = arr[end];
        }

        arr[start] = base;
        return start;
    }
}
