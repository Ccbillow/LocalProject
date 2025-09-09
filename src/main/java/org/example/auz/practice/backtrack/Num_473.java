package org.example.auz.practice.backtrack;

/**
 * 473. matchsticks-to-square
 * https://leetcode.cn/problems/matchsticks-to-square/description/
 */
public class Num_473 {

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
        boolean[] visited = new boolean[matchsticks.length];
        return dfs(k, 0, matchsticks, 0, visited, target);
    }

    private boolean dfs(int k, int bucket, int[] matchsticks, int idx, boolean[] visited, int target) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            return dfs(k - 1, 0, matchsticks, 0, visited, target);
        }

        for (int i = idx; i < matchsticks.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (bucket + matchsticks[i] > target) {
                continue;
            }

            bucket = bucket + matchsticks[i];
            visited[i] = true;
            if (dfs(k, bucket, matchsticks, i + 1, visited, target)) {
                return true;
            }
            visited[i] = false;
            bucket = bucket - matchsticks[i];
        }
        return false;
    }

}
