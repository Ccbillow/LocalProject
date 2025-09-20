package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/
 */
public class Num_322_3 {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        for (int[] d : dp) {
            Arrays.fill(d, amount + 1);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[n][amount] == amount + 1 ? -1 : dp[n][amount];
    }

    public static void main(String[] args) {
        Num_322_3 test = new Num_322_3();

        int[] coins = {1, 2, 5};
        test.coinChange(coins, 5);
    }
}
