package org.example.auz.practice.arr;

/**
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class Num_80_1 {

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;

        int count = 0;

        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left] = nums[right];
                left++;
            } else if (left < right && count < 2) {
                nums[left] = nums[right];
                left++;
            }

            right++;
            count++;

            if (right < nums.length && nums[right] != nums[right - 1]) {
                count = 0;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
    }
}
