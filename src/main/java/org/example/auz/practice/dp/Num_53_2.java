package org.example.auz.practice.dp;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Num_53_2 {

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
