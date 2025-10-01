package org.example.auz.practice.dp;

/**
 * 64. minimum-path-sum
 * https://leetcode.cn/problems/minimum-path-sum/description/
 */
public class Num_64_1 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return dfs(grid, m - 1, n - 1);
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE / 2;
        }

        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        int val = grid[i][j];
        return Math.min(dfs(grid, i - 1, j) + val, dfs(grid, i, j - 1) + val);
    }
}
