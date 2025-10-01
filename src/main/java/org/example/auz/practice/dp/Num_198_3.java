package org.example.auz.practice.dp;

/**
 * 198. house-robber
 * https://leetcode.cn/problems/house-robber/description/
 */
public class Num_198_3 {

    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        }

        return dp[n + 1];
    }


}
