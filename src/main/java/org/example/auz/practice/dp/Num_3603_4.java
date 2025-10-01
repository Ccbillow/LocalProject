package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 3603. minimum-cost-path-with-alternating-directions-ii
 * https://leetcode.cn/problems/minimum-cost-path-with-alternating-directions-ii/description/
 */
public class Num_3603_4 {

    public long minCost(int m, int n, int[][] waitCost) {
        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + (i + 1) + waitCost[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + (j + 1) + waitCost[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long cost = (long) (i + 1) * (j + 1) + waitCost[i][j];
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + cost;
            }
        }
        return dp[m - 1][n - 1] - waitCost[m - 1][n - 1];
    }

}
