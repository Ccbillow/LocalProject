package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 354. Russian Doll Envelopes
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 */
public class Num_354_1 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }

        return lis(height);
    }

    private int lis(int[] height) {
        int[] dp = new int[height.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
