package org.example.auz.practice.dp;

/**
 * 0-1 pack
 */
public class Knapsack {

    public  int knapsack(int V, int[] weights, int[] values) {
        int n = weights.length;

        int[][] dp = new int[n][V + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= V; j++) {
            if (weights[0] > j) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = values[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= V; j++) {

                if (j < weights[i]) {
                    // not choose i
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            // not choose i
                            dp[i - 1][j],
                            // choose i
                            dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        return dp[n - 1][V];
    }

    public int pack(int V, int[] weights, int[] values) {
        int n = weights.length;

        int[][] dp = new int[n + 1][V + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= V; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[n][V];
    }
}
