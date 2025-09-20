package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/description/
 */
public class Num_72_2 {

    int[][] memo;

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(word1, m - 1, word2, n - 1);
    }

    private int dp(String word1, int i, String word2, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dp(word1, i - 1, word2, j - 1);
        } else {
            memo[i][j] = 1 + min(
                    dp(word1, i, word2, j - 1),
                    dp(word1, i - 1, word2, j),
                    dp(word1, i - 1, word2, j - 1)
            );
        }
        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
