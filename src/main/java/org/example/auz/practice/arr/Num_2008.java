package org.example.auz.practice.arr;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2008. maximum-earnings-from-taxi
 * https://leetcode.cn/problems/maximum-earnings-from-taxi/description/
 */
public class Num_2008 {

    public long maxTaxiEarnings(int n, int[][] rides) {
        int k = rides.length;
        int[][] profit = new int[k][3];
        for (int i = 0; i < k; i++) {
            int from = rides[i][0];
            int to = rides[i][1];
            int fee = rides[i][2];
            profit[i] = new int[]{from, to, to - from + fee};
        }

        Arrays.sort(profit, Comparator.comparingInt(a -> a[1]));

        long[] dp = new long[k];
        dp[0] = profit[0][2];

        for (int i = 1; i < k; i++) {
            long notChoose = dp[i - 1];

            long choose = profit[i][2];

            int idx = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (profit[j][1] <= profit[i][0]) {
                    idx = j;
                    break;
                }
            }

            if (idx != -1) {
                choose += dp[idx];
            }

            dp[i] = Math.max(notChoose, choose);
        }

        return dp[k - 1];
    }
}
