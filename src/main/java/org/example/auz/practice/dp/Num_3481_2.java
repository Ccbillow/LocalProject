package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 3418. maximum-amount-of-money-robot-can-earn
 * https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn/description/
 */
public class Num_3481_2 {

    int m, n;
    int[][][] memo;
    
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;

        memo = new int[m][n][3];
        for (int[][] arr : memo) {
            for (int[] a : arr) {
                Arrays.fill(a, Integer.MIN_VALUE);
            }
        }

        return dfs(m - 1, n - 1, coins, 2);
    }

    private int dfs(int i, int j, int[][] coins, int k) {
        if (i < 0 || j < 0) {
            return Integer.MIN_VALUE;
        }

        int val = coins[i][j];

        if (i == 0 && j == 0) {
            return (val < 0 && k > 0) ? 0 : val;
        }

        if (memo[i][j][k] != Integer.MIN_VALUE) {
            return memo[i][j][k];
        }

        // take
        int res = val + Math.max(dfs(i, j - 1, coins, k), dfs(i - 1, j, coins, k));

        // not take
        if (val < 0 && k > 0) {
            res = Math.max(res,
                    0 + Math.max(dfs(i, j - 1, coins, k - 1), dfs(i - 1, j, coins, k - 1)));
        }

        return memo[i][j][k] = res;
    }



}
