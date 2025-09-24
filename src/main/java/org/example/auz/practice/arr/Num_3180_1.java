package org.example.auz.practice.arr;

import java.util.Arrays;

/**
 * maximum-total-reward-using-operations-i
 * https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/?show=1
 */
public class Num_3180_1 {

    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);

        return dfs(rewardValues, 0, 0);
    }

    private int dfs(int[] rewardValues, int idx, int cur) {
        if (idx == rewardValues.length) {
            return cur;
        }


        int notChoose = dfs(rewardValues, idx + 1, cur);

        int choose = 0;
        if (rewardValues[idx] > cur) {
            choose = dfs(rewardValues, idx + 1, cur + rewardValues[idx]);
        }

        return Math.max(notChoose, choose);
    }
}
