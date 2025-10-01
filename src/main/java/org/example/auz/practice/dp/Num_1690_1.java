package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 1690. 石子游戏 VII
 * https://leetcode.cn/problems/stone-game-vii/description/
 */
public class Num_1690_1 {

    public int stoneGameVII(int[] stones) {
        int sum = Arrays.stream(stones).sum();

        return dfs(stones, 0, stones.length - 1, sum);
    }

    private int dfs(int[] stones, int l, int r, int sum) {
        if (l == r) {
            return 0;
        }


        int left = sum - stones[l];
        int removeLeft = left - dfs(stones, l + 1, r, left);

        int right = sum - stones[r];
        int removeRight = right - dfs(stones, l, r - 1, right);


        return Math.max(removeLeft, removeRight);
    }
}
