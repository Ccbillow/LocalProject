package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * maximum-total-reward-using-operations-i
 * https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/?show=1
 */
public class Num_3180_2 {

    int[][] memo;

    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);

        int n = rewardValues.length;
        int sum = Arrays.stream(rewardValues).sum();

        memo = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(rewardValues, 0, 0);
    }

    private int dfs(int[] rewardValues, int idx, int cur) {
        if (idx == rewardValues.length) {
            return cur;
        }

        if (memo[idx][cur] != -1) {
            return memo[idx][cur];
        }

        int notChoose = dfs(rewardValues, idx + 1, cur);

        int choose = 0;
        if (rewardValues[idx] > cur) {
            choose = dfs(rewardValues, idx + 1, cur + rewardValues[idx]);
        }

        memo[idx][cur] = Math.max(notChoose, choose);
        return memo[idx][cur];
    }
}
