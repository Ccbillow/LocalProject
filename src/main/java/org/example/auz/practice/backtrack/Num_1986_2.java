package org.example.auz.practice.backtrack;

/**
 * 1986. minimum-number-of-work-sessions-to-finish-the-tasks
 * https://leetcode.cn/problems/minimum-number-of-work-sessions-to-finish-the-tasks/description/
 */
public class Num_1986_2 {

    int res = Integer.MAX_VALUE;

    public int minSessions(int[] tasks, int sessionTime) {
        int[] bucket = new int[tasks.length];

        dfs(tasks, bucket, tasks.length - 1, sessionTime);

        return res;
    }

    private void dfs(int[] tasks, int[] bucket, int idx, int sessionTime) {
        if (idx < 0) {
            int cur = 0;
            for (int b : bucket) {
                if (b > 0) {
                    cur++;
                }
            }
            res = Math.min(res, cur);
            return;
        }

        int task = tasks[idx];

        for (int i = 0; i < bucket.length; i++) {
            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }

            if (bucket[i] + task <= sessionTime) {
                bucket[i] += task;
                dfs(tasks, bucket, idx - 1, sessionTime);
                bucket[i] -= task;
            }

            if (bucket[i] == 0) {
                break;
            }
        }
    }


}
