package org.example.interview.search;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] > key) {
            binarySearch(arr, start, mid - 1, key);
        } else {
            binarySearch(arr, mid + 1, end, key);
        }
        return mid;
    }

    public static int binary(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] > key) {
            binarySearch(arr, start, mid - 1, key);
        } else {
            binarySearch(arr, mid + 1, end, key);
        }
        return mid;
    }
}
