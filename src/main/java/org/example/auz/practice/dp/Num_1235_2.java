package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 1235. maximum-profit-in-job-scheduling
 * https://leetcode.cn/problems/maximum-profit-in-job-scheduling/description/?show=1
 */
public class Num_1235_2 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int notChoose = dp[i - 1];

            int choose = jobs[i][2];

            int idx = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j][1] <= jobs[i][0]) {
                    idx = j;
                    break;
                }
            }

            if (idx != -1) {
                choose = choose + dp[idx];
            }

            dp[i] = Math.max(notChoose, choose);
        }

        return dp[n - 1];
    }
}
