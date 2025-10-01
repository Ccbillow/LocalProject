package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 198. house-robber
 * https://leetcode.cn/problems/house-robber/description/
 */
public class Num_198_2 {

    int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);

        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        return memo[i] = Math.max(dfs(nums, i + 2) + nums[i], dfs(nums, i + 1));
    }
}
