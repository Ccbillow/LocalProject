package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 746. min-cost-climbing-stairs
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 */
public class Num_746_3 {

    int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        memo = new int[n];
        Arrays.fill(memo, -1);

        return dfs(n, cost);
    }

    private int dfs(int i, int[] cost) {
        if (i == 1 || i == 0) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int a = dfs(i - 1, cost) + cost[i - 1];
        int b = dfs(i - 2, cost) + cost[i - 2];
        return memo[i] = Math.min(a, b);
    }
}
