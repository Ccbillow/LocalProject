package org.example.auz.practice.backtrack;

/**
 * 1986. minimum-number-of-work-sessions-to-finish-the-tasks
 * https://leetcode.cn/problems/minimum-number-of-work-sessions-to-finish-the-tasks/description/
 */
public class Num_1986_1 {

    int res = Integer.MAX_VALUE;

    public int minSessions(int[] tasks, int sessionTime) {
        int[] bucket = new int[tasks.length];

        dfs(tasks, bucket, 0, sessionTime, 0);

        return res;
    }

    private void dfs(int[] tasks, int[] bucket, int idx, int sessionTime, int bucketIndex) {
        if (bucketIndex >= res) {
            return;
        }

        if (idx == tasks.length) {
            res = bucketIndex;
            return;
        }

        for (int i = 0; i < bucketIndex; i++) {
            if (bucket[i] + tasks[idx] > sessionTime) {
                continue;
            }

            bucket[i] += tasks[idx];
            dfs(tasks, bucket, idx + 1, sessionTime, bucketIndex);
            bucket[i] -= tasks[idx];
        }

        bucket[bucketIndex] = tasks[idx];
        dfs(tasks, bucket, idx + 1, sessionTime, bucketIndex + 1);
        bucket[bucketIndex] = 0;
    }
}
