package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2304. minimum-path-cost-in-a-grid
 * https://leetcode.cn/problems/minimum-path-cost-in-a-grid/description/
 */
public class Num_2304_2 {

    // int val = grid[x][y]
    // int cost = moveCost[val][col_index]

    int m, n;
    int[][] memo;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dfs(grid, moveCost, 0, j));
        }
        return res;
    }

    private int dfs(int[][] grid, int[][] moveCost, int i, int j) {
        if (i == m - 1) {
            return grid[i][j];
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            res = Math.min(res, dfs(grid, moveCost, i + 1, k) + moveCost[grid[i][j]][k]);
        }

        return memo[i][j] = res + grid[i][j];
    }


}
