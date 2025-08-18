package org.example.auz.practice.arr;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 */
public class Num_75_2 {

    public static void sortColorsRecursion(int[] nums) {
        int left = sortTarget(nums, 2, nums.length);
        sortTarget(nums, 1, left);
    }

    private static int sortTarget(int[] nums, int target, int n) {
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != target) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        for (int i = left; i < n; i++) {
            nums[i] = target;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColorsRecursion(arr);

    }
}
