package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * maximum-total-reward-using-operations-i
 * https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/?show=1
 */
public class Num_3180_1 {

    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        return dfs(0, 0, rewardValues);
    }

    private int dfs(int i, int j, int[] rewardValues) {
        if (i == rewardValues.length) {
            return j;
        }

        int res = dfs(i + 1, j, rewardValues);
        if (rewardValues[i] > j) {
            res = Math.max(res, dfs(i + 1, j + rewardValues[i], rewardValues));
        }
        return res;
    }
}
