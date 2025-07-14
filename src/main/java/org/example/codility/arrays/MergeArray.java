package org.example.codility.arrays;

import java.util.Arrays;

public class MergeArray {

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int index = 0;
        int left = 0;
        int right = 0;
        while (left < arr1.length && right < arr2.length) {
            if (arr1[left] <= arr2[right]) {
                res[index] = arr1[left];
                index++;
                left++;
            } else{
                res[index] = arr2[right];
                index++;
                right++;
            }
        }

        while (left < arr1.length) {
            res[index] = arr1[left];
            index++;
            left++;
        }

        while (right < arr2.length) {
            res[index] = arr2[right];
            index++;
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        int[] result = merge(a, b);
        System.out.println(Arrays.toString(result));
    }
}
