package org.example.auz.practice.backtrack;

/**
 * 1723. find-minimum-time-to-finish-all-jobs
 * https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/description/
 */
public class Num_1723_1 {


    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k];
        dfs(jobs, 0, workers);
        return res;
    }

    private void dfs(int[] jobs, int jobId, int[] workers) {
        if (jobId == jobs.length) {
            int max = 0;
            for (int worker : workers) {
                max = Math.max(max, worker);
            }
            res = Math.min(res, max);
            return;
        }

        for (int i = 0; i < workers.length; i++) {
            if (workers[i] + jobs[jobId] > res) {
                continue;
            }

            workers[i] = workers[i] + jobs[jobId];
            dfs(jobs, jobId + 1, workers);
            workers[i] = workers[i] - jobs[jobId];

            if (workers[i] == 0) break;

        }
    }


}
