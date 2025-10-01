package org.example.auz.practice.dp;

/**
 * 877. stone-game
 * https://leetcode.cn/problems/stone-game/description/
 */
public class Num_877 {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][piles.length - 1] > 0;
    }
}
