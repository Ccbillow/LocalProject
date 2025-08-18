package org.example.auz.practice.arr;

/**
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class Num_80_2 {

    public static int removeDuplicates(int[] nums) {
        int left = 2;
        int right = 2;
        while (right < nums.length) {
            if (nums[right] != nums[left - 2]) {
                nums[left] = nums[right];
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
    }
}
