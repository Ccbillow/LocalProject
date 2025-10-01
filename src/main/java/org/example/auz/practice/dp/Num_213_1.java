package org.example.auz.practice.dp;

/**
 * 198. house-robber-ii
 * https://leetcode.cn/problems/house-robber-ii/description/
 */
public class Num_213_1 {


    public int rob(int[] nums) {
        int n = nums.length;

        return Math.max(
                dfs(nums, 0, n - 2),
                dfs(nums, 1, n - 1));
    }

    private int dfs(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }

        return Math.max(
                dfs(nums, start + 2, end) + nums[start],
                dfs(nums, start + 1, end));
    }
}
