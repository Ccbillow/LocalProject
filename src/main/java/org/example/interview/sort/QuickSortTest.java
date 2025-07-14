package org.example.interview.sort;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{19, 28, 8, 23, 10, 21, 9};
        System.out.println("要排序的初始化数据：" + Arrays.toString(arr));
        //从小到大排序
        quickSort(arr);
        System.out.println("最后排序后的结果：" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
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
