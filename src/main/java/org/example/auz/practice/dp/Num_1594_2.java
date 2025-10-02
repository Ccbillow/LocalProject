package org.example.auz.practice.dp;

/**
 * 1594. maximum-non-negative-product-in-a-matrix
 * https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix/description/
 */
public class Num_1594_2 {

    public int maxProductPath(int[][] grid) {
        int mod = 1_000_000_007;

        int m = grid.length;
        int n = grid[0].length;

        long[][] maxDp = new long[m][n];
        long[][] minDp = new long[m][n];
        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0] * grid[i][0], minDp[i - 1][0] * grid[i][0]);
            minDp[i][0] = Math.min(maxDp[i - 1][0] * grid[i][0], minDp[i - 1][0] * grid[i][0]);
        }
        for (int j = 1; j < n; j++) {
            maxDp[0][j] = Math.max(maxDp[0][j - 1] * grid[0][j], minDp[0][j - 1] * grid[0][j]);
            minDp[0][j] = Math.min(maxDp[0][j - 1] * grid[0][j], minDp[0][j - 1] * grid[0][j]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long maxUp = Math.max(maxDp[i - 1][j] * grid[i][j], minDp[i - 1][j] * grid[i][j]);
                long maxLeft = Math.max(maxDp[i][j - 1] * grid[i][j], minDp[i][j - 1] * grid[i][j]);
                maxDp[i][j] = Math.max(maxUp, maxLeft);

                long minUp = Math.min(maxDp[i - 1][j] * grid[i][j], minDp[i - 1][j] * grid[i][j]);
                long minLeft = Math.min(maxDp[i][j - 1] * grid[i][j], minDp[i][j - 1] * grid[i][j]);
                minDp[i][j] = Math.min(minUp, minLeft);
            }
        }
        return (int) Math.max(maxDp[m - 1][n - 1] % mod, -1);
    }
}
