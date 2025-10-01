package org.example.auz.practice.dp;

/**
 * 3418. maximum-amount-of-money-robot-can-earn
 * https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn/description/
 */
public class Num_3481_1 {

    int m, n;

    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;

        return dfs(m - 1, n - 1, coins, 2);
    }

    private int dfs(int i, int j, int[][] coins, int k) {
        if (i < 0 || j < 0) {
            return 0;
        }

        // 此处可以不抵消
        int val = coins[i][j];
        if (val < 0 && k > 0) {
            val = 0;
            k--;
        }

        if (i == 0 && j == 0) {
            return val;
        }

        int left = dfs(i, j - 1, coins, k);
        int up = dfs(i - 1, j, coins, k);

        return Math.max(left, up) + val;
    }


}
