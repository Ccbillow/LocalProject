package org.example.auz.practice.dp;

/**
 * 62. unique-paths
 * https://leetcode.cn/problems/unique-paths/description/
 */
public class Num_62_1 {

    public int uniquePaths(int m, int n) {
        return dp(m - 1, n - 1);
    }

    private int dp(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (x == 0 && y == 0) {
            return 1;
        }

        return dp(x - 1, y) + dp(x, y - 1);
    }
}
