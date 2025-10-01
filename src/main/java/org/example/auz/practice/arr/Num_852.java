package org.example.auz.practice.arr;

/**
 * 852. peak-index-in-a-mountain-array
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/description/
 */
public class Num_852 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) << 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
