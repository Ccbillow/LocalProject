package org.example.auz.practice.dp;

/**
 * 3603. minimum-cost-path-with-alternating-directions-ii
 * https://leetcode.cn/problems/minimum-cost-path-with-alternating-directions-ii/description/
 */
public class Num_3603_2 {

    public long minCost(int m, int n, int[][] waitCost) {
        return dfs(m - 1, n - 1, waitCost) - waitCost[m - 1][n - 1];
    }

    private long dfs(int i, int j, int[][] waitCost) {
        if (i < 0 || j < 0) {
            return Long.MAX_VALUE;
        }
        if (i == 0 && j == 0) {
            return 1;
        }

        long cost = (long) (i + 1) * (j + 1) + waitCost[i][j];
        return Math.min(dfs(i - 1, j, waitCost), dfs(i, j - 1, waitCost)) + cost;
    }

}
