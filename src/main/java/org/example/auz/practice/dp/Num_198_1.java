package org.example.auz.practice.dp;

/**
 * 198. house-robber
 * https://leetcode.cn/problems/house-robber/description/
 */
public class Num_198_1 {

    public int rob(int[] nums) {
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        return Math.max(dfs(nums, i + 2) + nums[i], dfs(nums, i + 1));
    }
}
