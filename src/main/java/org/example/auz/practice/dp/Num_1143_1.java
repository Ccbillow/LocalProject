package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 1143. longest-common-subsequence
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 */
public class Num_1143_1 {

    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(text1, text2, 0, 0);
    }

    private int dp(String a, String b, int i, int j) {
        if (i == a.length() || j == b.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (a.charAt(i) == b.charAt(j)) {
            memo[i][j] = 1 + dp(a, b, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(dp(a, b, i + 1, j), dp(a, b, i, j + 1));
        }
        return memo[i][j];
    }
}
