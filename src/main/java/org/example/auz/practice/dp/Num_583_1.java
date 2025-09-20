package org.example.auz.practice.dp;

/**
 * 583. 两个字符串的删除操作
 * https://leetcode.cn/problems/delete-operation-for-two-strings/description/
 */
public class Num_583_1 {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int lcs = lcs(word1, word2);

        return m - lcs + n - lcs;
    }

    private int lcs(String a, String b) {
        int m = a.length(), n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
