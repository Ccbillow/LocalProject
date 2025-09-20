package org.example.auz.practice.backtrack;

/**
 * 473. matchsticks-to-square
 * https://leetcode.cn/problems/matchsticks-to-square/description/
 */
public class Num_473_2 {

    public boolean makesquare(int[] matchsticks) {
        return partion(matchsticks, 4);
    }

    private boolean partion(int[] matchsticks, int k) {
        if (k > matchsticks.length) {
            return false;
        }

        int sum = 0;
        for (int m : matchsticks) {
            sum = sum + m;
        }
        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        int[] bucket = new int[k];

        return dfs(matchsticks, bucket, 0, target);
    }

    private boolean dfs(int[] matchsticks, int[] bucket, int idx, int target) {
        if (idx == matchsticks.length) {
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }

            if (bucket[i] + matchsticks[idx] > target) {
                continue;
            }

            bucket[i] += matchsticks[idx];

            if (dfs(matchsticks, bucket, idx + 1, target)) {
                return true;
            }

            bucket[i] -= matchsticks[idx];
        }
        return false;
    }


}
