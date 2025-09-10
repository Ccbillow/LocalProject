package org.example.auz.practice.backtrack;

import java.util.Arrays;

/**
 * 1011. capacity-to-ship-packages-within-d-days
 * https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/description/
 */
public class Num_1011 {

    int res = Integer.MAX_VALUE;

    public int shipWithinDays(int[] weights, int days) {
        int[] workloads = new int[days];
        dfs(weights, 0, workloads);
        return res;
    }

    private void dfs(int[] weights, int idx, int[] workloads) {
        if (idx == weights.length) {
            int max = 0;
            for (int workload : workloads) {
                max = Math.max(max, workload);
            }
            res = Math.min(res, max);
            return;
        }

        for (int i = 0; i < workloads.length; i++) {
            if (workloads[i] + weights[idx] > res) {
                continue;
            }

            workloads[i] = workloads[i] + weights[idx];
            dfs(weights, idx + 1, workloads);
            workloads[i] = workloads[i] - weights[idx];

            if (workloads[i] == 0) break;
        }
    }

}
