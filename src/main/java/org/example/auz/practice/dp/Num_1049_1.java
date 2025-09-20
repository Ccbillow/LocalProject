package org.example.auz.practice.dp;

/**
 * 1049. last-stone-weight-ii
 * https://leetcode.cn/problems/last-stone-weight-ii/description/
 */
public class Num_1049_1 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;

        int n = stones.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i <= n; i++) {
            int stone = stones[i - 1];
            for (int j = 0; j <= target; j++) {
                if (j < stone) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stone] + stone);
                }
            }
        }
        return sum - 2 * dp[n][target];
    }
}
