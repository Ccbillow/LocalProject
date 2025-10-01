package org.example.auz.practice.dp;

/**
 * 1872. stone-game-viii
 * https://leetcode.cn/problems/stone-game-viii/description/
 */
public class Num_1872_1 {

    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

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

        int res = Math.max(dfs(idx + 1, preSum), preSum[idx] - dfs(idx + 1, preSum));

        return res;
    }
}
