package org.example.auz.practice.dp;

import java.util.List;

/**
 * 120. triangle
 * https://leetcode.cn/problems/triangle/description/
 */
public class Num_120_2 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        int[][] dp = new int[m][m];
        for (int j = 0; j < m; j++) {
            dp[m - 1][j] = triangle.get(m - 1).get(j);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


}
