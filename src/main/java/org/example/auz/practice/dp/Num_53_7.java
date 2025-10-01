package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Num_53_7 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 1];
        dp[0] = Integer.MIN_VALUE / 2;

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

}
