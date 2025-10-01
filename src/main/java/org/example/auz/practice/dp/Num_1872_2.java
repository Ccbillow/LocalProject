package org.example.auz.practice.dp;

/**
 * 1872. stone-game-viii
 * https://leetcode.cn/problems/stone-game-viii/description/
 */
public class Num_1872_2 {

    Integer[] memo;
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        memo = new Integer[n + 1];

        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= stones.length; i++) {
            preSum[i] = preSum[i - 1] + stones[i - 1];
        }

        return dfs(2, preSum);
    }

    private int dfs(int idx, int[] preSum) {
        if (idx == preSum.length - 1) {
            return preSum[idx];
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        int option1 = dfs(idx + 1, preSum);
        int option2 = preSum[idx] - dfs(idx + 1, preSum);

        return memo[idx] = Math.max(option1, option2);
    }
}
