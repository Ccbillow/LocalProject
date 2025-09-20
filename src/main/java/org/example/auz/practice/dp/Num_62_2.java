package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 62. unique-paths
 * https://leetcode.cn/problems/unique-paths/description/
 */
public class Num_62_2 {

    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];

        return dp(m - 1, n - 1);
    }

    private int dp(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (x == 0 && y == 0) {
            return 1;
        }

        if (memo[x][y] > 0) {
            return memo[x][y];
        }

        memo[x][y] = dp(x - 1, y) + dp(x, y - 1);

        return memo[x][y];
    }
}
