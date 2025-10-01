package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 64. minimum-path-sum
 * https://leetcode.cn/problems/minimum-path-sum/description/
 */
public class Num_64_3 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][1] = 0;
        dp[1][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int val = grid[i - 1][j - 1];
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + val;
            }
        }
        return dp[m][n];
    }

}
