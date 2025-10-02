package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2787. ways-to-express-an-integer-as-sum-of-powers
 * https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/description/
 */
public class Num_2787_2 {

    int[][] memo;

    int mod = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        memo = new int[n + 1][n + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return dfs(n, n, x);
    }

    private int dfs(int i, int j, int x) {
        if (j == 0) {
            return 1;
        }

        if (i == 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        long res = dfs(i - 1, j, x);

        int pow = (int) Math.pow(i, x);
        if (j >= pow) {
            res += dfs(i - 1, j - pow, x);
        }
        return memo[i][j] = (int) (res % mod);
    }
}
