package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 1289. minimum-falling-path-sum-ii
 * https://leetcode.cn/problems/minimum-falling-path-sum-ii/description/
 */
public class Num_1289_2 {

    int m, n;
    int[][] memo;

    public int minFallingPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dfs(m - 1, j, grid));
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i == 0) {
            return grid[i][j];
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (k == j) {
                continue;
            }
            res = Math.min(res, dfs(i - 1, k, grid));
        }

        return memo[i][j] = res + grid[i][j];
    }
}
