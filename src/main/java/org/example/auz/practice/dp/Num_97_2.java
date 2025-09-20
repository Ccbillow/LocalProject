package org.example.auz.practice.dp;

/**
 * 97. interleaving-string
 * https://leetcode.cn/problems/interleaving-string/description/?show=1
 */
public class Num_97_2 {

    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null) s1 = "";
        if(s2 == null) s2 = "";
        if(s3 == null) s3 = "";

        memo = new Boolean[s1.length()][s2.length()];

        return dfs(s1, s2, s3, 0, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }

        if (k >= s3.length()) {
            return memo[i][j] = false;
        }

        if (i < s1.length()) {
            if (s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j, k + 1)) {
                return true;
            }
        }

        if (j < s2.length()) {
            if (s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1, k + 1)) {
                return true;
            }
        }

        return memo[i][j] = false;
    }
}
