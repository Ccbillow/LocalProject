package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * maximum-total-reward-using-operations-i
 * https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/?show=1
 */
public class Num_3180_4 {


    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues); // 先排序，保证从小到大选

        int maxSum = Arrays.stream(rewardValues).sum(); // 奖励和的最大值
        boolean[] dp = new boolean[maxSum + 1];
        dp[0] = true; // 和为0一定能做到

        int res = 0;
        for (int v : rewardValues) {
            // 倒序遍历，避免一个数被用多次
            for (int s = maxSum; s >= 0; s--) {
                if (dp[s] && v > s) { // 只有当当前数比已有和大，才能扩展
                    dp[s + v] = true;
                    res = Math.max(res, s + v);
                }
            }
        }

        return res;
    }

}
