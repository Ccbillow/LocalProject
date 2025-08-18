package org.example.auz.practice.arr;

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */
public class Num_977 {

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int index = nums.length - 1;
        int j = nums.length - 1;
        int[] res = new int[nums.length];

        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[index] = nums[i] * nums[i];
                i++;
            } else {
                res[index] = nums[j] * nums[j];
                j--;
            }
            index--;
        }
        return res;
    }
}
