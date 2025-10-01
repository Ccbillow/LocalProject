package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 1289. minimum-falling-path-sum-ii
 * https://leetcode.cn/problems/minimum-falling-path-sum-ii/description/
 */
public class Num_1289_3 {


    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < n; k++) {
                    if (k == j) continue;

                    min = Math.min(min, dp[i - 1][k] + grid[i][j]);
                }

                dp[i][j] = min;
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }


}
