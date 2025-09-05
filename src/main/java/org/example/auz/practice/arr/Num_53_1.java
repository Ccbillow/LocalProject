package org.example.auz.practice.arr;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Num_53_1 {

    public int maxSubArray(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
