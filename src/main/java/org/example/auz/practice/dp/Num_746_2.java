package org.example.auz.practice.dp;

/**
 * 746. min-cost-climbing-stairs
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 */
public class Num_746_2 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
