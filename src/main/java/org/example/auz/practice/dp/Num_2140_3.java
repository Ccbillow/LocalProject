package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2140. solving-questions-with-brainpower
 * https://leetcode.cn/problems/solving-questions-with-brainpower/description/?show=1
 */
public class Num_2140_3 {


    public long mostPoints(int[][] questions) {
        int n = questions.length;

        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            long notTake = dp[i + 1];

            long take;
            int idx = i + questions[i][1] + 1;
            if (idx >= n) {
                take = questions[i][0];
            } else {
                take = dp[idx] + questions[i][0];
            }

            dp[i] = Math.max(take, notTake);
        }
        return dp[0];
    }


}
