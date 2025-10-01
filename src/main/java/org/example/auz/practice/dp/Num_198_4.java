package org.example.auz.practice.dp;

/**
 * 198. house-robber
 * https://leetcode.cn/problems/house-robber/description/
 */
public class Num_198_4 {

    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 0; i < n; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }

        return dp[n + 1];
    }


}
