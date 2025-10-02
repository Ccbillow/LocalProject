package org.example.auz.practice.dp;

/**
 * 2787. ways-to-express-an-integer-as-sum-of-powers
 * https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/description/
 */
public class Num_2787_3 {


    public int numberOfWays(int n, int x) {
        int mod = 1_000_000_007;

        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int num = (int) Math.pow(i, x);

            for (int j = 0; j <= n; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }

        return (int) (dp[n][n] % mod);
    }


}
