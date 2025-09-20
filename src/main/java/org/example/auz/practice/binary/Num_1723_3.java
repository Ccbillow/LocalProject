package org.example.auz.practice.binary;

/**
 * 1723. find-minimum-time-to-finish-all-jobs
 * https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/description/
 */
public class Num_1723_3 {

    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] bucket = new int[k];

        dfs(jobs, bucket, jobs.length - 1);

        return res;
    }

    private void dfs(int[] jobs, int[] bucket, int idx) {
        if (idx < 0) {
            int max = 0;
            for (int b : bucket) {
                max = Math.max(max, b);
            }
            res = Math.min(res, max);
            return;
        }

        int job = jobs[idx];

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + job < res) {
                bucket[i] += job;
                dfs(jobs, bucket, idx - 1);
                bucket[i] -= job;

                if (bucket[i] == 0) break;
            }
        }
    }
}
