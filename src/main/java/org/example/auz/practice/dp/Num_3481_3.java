package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 3418. maximum-amount-of-money-robot-can-earn
 * https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn/description/
 */
public class Num_3481_3 {

    
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];
        dp[0][0][0] = coins[0][0];
        dp[0][0][1] = Math.max(0, coins[0][0]);
        dp[0][0][2] = Math.max(0, coins[0][0]);

        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i - 1][0][0] + coins[i][0];
            dp[i][0][1] = Math.max(
                    dp[i - 1][0][0] + Math.max(0, coins[i][0]),
                    dp[i - 1][0][1] + coins[i][0]);
            dp[i][0][2] = Math.max(
                    dp[i - 1][0][1] + Math.max(0, coins[i][0]),
                    dp[i - 1][0][2] + coins[i][0]);
        }

        for (int j = 1; j < n; j++) {
            dp[0][j][0] = dp[0][j - 1][0] + coins[0][j];
            dp[0][j][1] = Math.max(
                    dp[0][j - 1][0] + Math.max(0, coins[0][j]),
                    dp[0][j - 1][1] + coins[0][j]);
            dp[0][j][2] = Math.max(
                    dp[0][j - 1][1] + Math.max(0, coins[0][j]),
                    dp[0][j - 1][2] + coins[0][j]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + coins[i][j];
                dp[i][j][1] = Math.max(
                        Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + Math.max(0, coins[i][j]),
                        Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + coins[i][j]);
                dp[i][j][2] = Math.max(
                        Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + Math.max(0, coins[i][j]),
                        Math.max(dp[i - 1][j][2], dp[i][j - 1][2]) + coins[i][j]);
            }
        }

        return Arrays.stream(dp[m - 1][n - 1]).max().getAsInt();
    }




}
