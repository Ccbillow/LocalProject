package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/
 */
public class Num_322_2 {

    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != amount + 1) {
            return memo[amount];
        }


        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, amount - coin);
            if (sub == -1) {
                continue;
            }

            res = Math.min(res, sub + 1);
        }

        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;

        return memo[amount];
    }
}
