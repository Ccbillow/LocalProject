package org.example.auz.practice.arr;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 */
public class Num_75_1 {

    public static void sortColors(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 2) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        for (int i = left; i < nums.length; i++) {
            nums[i] = 2;
        }

        int i = 0;
        int j = 0;
        while (j < left) {
            if (nums[j] != 1) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        for (int k = i; k < left; k++) {
            nums[k] = 1;
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
    }
}
