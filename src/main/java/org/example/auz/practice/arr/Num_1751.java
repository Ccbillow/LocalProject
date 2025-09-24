package org.example.auz.practice.arr;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1751. maximum-number-of-events-that-can-be-attended-ii
 * https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/description/
 */
public class Num_1751 {

    public int maxValue(int[][] events, int k) {
        int n = events.length;

        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int start = events[i - 1][0];
            int end = events[i - 1][1];
            int val = events[i - 1][2];

            int idx = 0;
            for (int j = i - 1; j >= 1; j--) {
                if (events[j - 1][1] <= start) {
                    idx = j;
                    break;
                }
            }

            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] = Math.max(dp[i][j], dp[idx][j - 1] + val);
            }
        }
        return dp[n][k];
    }
}
