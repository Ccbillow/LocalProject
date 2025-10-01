package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 1690. 石子游戏 VII
 * https://leetcode.cn/problems/stone-game-vii/description/
 */
public class Num_1690_2 {

    Integer[][] memo;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        memo = new Integer[n][n];

        int sum = Arrays.stream(stones).sum();

        return dfs(stones, 0, stones.length - 1, sum);
    }

    private int dfs(int[] stones, int i, int j, int sum) {
        if (i == j) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int left = sum - stones[i];
        int leftRes = left - dfs(stones, i + 1, j, left);

        int right = sum - stones[j];
        int rightRes = right - dfs(stones, i, j - 1, right);


        return memo[i][j] = Math.max(leftRes, rightRes);
    }
}
