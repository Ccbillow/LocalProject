package org.example.auz.practice.dp;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Num_53_5 {

    public int maxSubArray(int[] nums) {
        int dp_0 = nums[0];
        int dp_1 = 0;
        int res = dp_0;

        for (int i = 1; i < nums.length; i++) {
            dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }

        return res;
    }
}
