package org.example.auz.practice.backtrack;

/**
 * 1723. find-minimum-time-to-finish-all-jobs
 * https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/description/
 */
public class Num_1723_2 {

    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k];
        dfs(jobs, 0, workers);
        return res;
    }

    private void dfs(int[] jobs, int idx, int[] workloads) {
        if (idx == jobs.length) {
            int max = 0;
            for (int worker : workloads) {
                max = Math.max(max, worker);
            }
            res = Math.min(res, max);
            return;
        }

        for (int i = 0; i < workloads.length; i++) {
            if (workloads[i] + jobs[idx] > res) {
                continue;
            }

            workloads[i] = workloads[i] + jobs[idx];
            dfs(jobs, idx + 1, workloads);
            workloads[i] = workloads[i] - jobs[idx];

            if (workloads[i] == 0) {
                break;
            }
        }
    }
}
