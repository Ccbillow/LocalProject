package org.example.auz.practice.arr;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class Num_283 {

    /*
        1 0 2 0 3 5

     */
    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 0, 3, 5};
        moveZeroes(arr);
    }
}
