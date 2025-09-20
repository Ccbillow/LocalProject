package org.example.auz.practice.graph.dfs;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/
 */
public class Num_322_3 {

    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {

        dfs(coins, 0, 0, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    void dfs(int[] coins, int cur, int step, int amount) {
        if (cur == amount) {
            res = Math.min(res, step);
            return;
        }

        if (cur > amount) {
            return;
        }

        for (int coin : coins) {
            dfs(coins, cur + coin, step + 1, amount);
        }
    }
}
