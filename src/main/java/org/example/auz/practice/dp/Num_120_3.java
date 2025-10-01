package org.example.auz.practice.dp;

import java.util.List;

/**
 * 120. triangle
 * https://leetcode.cn/problems/triangle/description/
 */
public class Num_120_3 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int d : dp[n - 1]) {
            res = Math.min(res, d);
        }

        return res;
    }


}
