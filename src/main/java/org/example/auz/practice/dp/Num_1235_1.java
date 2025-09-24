package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 1235. maximum-profit-in-job-scheduling
 * https://leetcode.cn/problems/maximum-profit-in-job-scheduling/description/?show=1
 */
public class Num_1235_1 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (int[] job : jobs) {
            int begin = job[0];
            int end = job[1];
            int val = job[2];

            dp.put(end, Math.max(dp.lastEntry().getValue(), dp.floorEntry(begin).getValue() + val));
        }

        return dp.lastEntry().getValue();
    }
}
