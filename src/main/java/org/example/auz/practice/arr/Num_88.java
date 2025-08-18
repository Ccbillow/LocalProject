package org.example.auz.practice.arr;

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class Num_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
        while (j >= 0) {
            nums1[index] = nums2[j];
            index--;
            j--;
        }
    }
}
