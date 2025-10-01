package org.example.auz.practice.dp;

/**
 * 746. min-cost-climbing-stairs
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 */
public class Num_746_1 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
