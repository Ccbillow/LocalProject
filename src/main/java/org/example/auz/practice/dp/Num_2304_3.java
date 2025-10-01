package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2304. minimum-path-cost-in-a-grid
 * https://leetcode.cn/problems/minimum-path-cost-in-a-grid/description/
 */
public class Num_2304_3 {

    // int val = grid[x][y]
    // int cost = moveCost[val][col_index]

    public int minPathCost(int[][] grid, int[][] moveCost) {
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
                    min = Math.min(min, dp[i - 1][k] + moveCost[grid[i - 1][k]][j]);
                }

                dp[i][j] = min + grid[i][j];
            }
        }

        // int res = Integer.MAX_VALUE;
        // for (int j = 0; j < n; j++) {
        //     res = Math.min(res, dp[m - 1][j]);
        // }

//        int res = Integer.MAX_VALUE;
//        for (int cost : dp[m - 1]) {
//            res = Math.min(res, cost);
//        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }


}
