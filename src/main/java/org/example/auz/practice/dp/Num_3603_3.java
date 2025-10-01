package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 3603. minimum-cost-path-with-alternating-directions-ii
 * https://leetcode.cn/problems/minimum-cost-path-with-alternating-directions-ii/description/
 */
public class Num_3603_3 {

    long[][] memo;
    public long minCost(int m, int n, int[][] waitCost) {
        memo = new long[m][n];
        for (long[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return dfs(m - 1, n - 1, waitCost) - waitCost[m - 1][n - 1];
    }

    private long dfs(int i, int j, int[][] waitCost) {
        if (i < 0 || j < 0) {
            return Long.MAX_VALUE;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        long cost = (long) (i + 1) * (j + 1) + waitCost[i][j];
        return memo[i][j] = Math.min(
                dfs(i - 1, j, waitCost),
                dfs(i, j - 1, waitCost)) + cost;
    }

}
