package org.example.auz.practice.dp;

/**
 * 474. ones-and-zeroes
 * https://leetcode.cn/problems/ones-and-zeroes/description/
 */
public class Num_474_4 {


    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            String str = strs[i - 1];

            int zero = 0;
            int one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zero++;
                if (c == '1') one++;
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j < zero || k < one) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zero][k - one] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }




}
