package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2611. mice-and-cheese
 * https://leetcode.cn/problems/mice-and-cheese/description/?show=1
 */
public class Num_2611_2 {

    int[][] memo;

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        memo = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
             Arrays.fill(memo[i], -1);
        }

        return dfs(0, k, reward1, reward2);
    }

    private int dfs(int i, int k, int[] reward1, int[] reward2) {
        if (i >= reward1.length) {
            return 0;
        }

        if (k == 0) {
            int sum = 0;
            while (i < reward2.length) {
                sum = sum + reward2[i];
                i++;
            }
            return sum;
        }

        if (memo[i][k] != -1) {
            return memo[i][k];
        }

        int take = reward1[i] + dfs(i + 1, k - 1, reward1, reward2);
        int notTake = reward2[i] + dfs(i + 1, k, reward1, reward2);
        return memo[i][k] = Math.max(take, notTake);
    }

}
