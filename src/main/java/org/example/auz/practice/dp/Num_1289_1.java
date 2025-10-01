package org.example.auz.practice.dp;

/**
 * 1289. minimum-falling-path-sum-ii
 * https://leetcode.cn/problems/minimum-falling-path-sum-ii/description/
 */
public class Num_1289_1 {

    int m, n;

    public int minFallingPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

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

        int res = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (k == j) {
                continue;
            }
            res = Math.min(res, dfs(i - 1, k, grid));
        }
        return res  + grid[i][j];
    }
}
