package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 198. house-robber-ii
 * https://leetcode.cn/problems/house-robber-ii/description/
 */
public class Num_213_2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] memo1 = new int[n + 1];
        int[] memo2 = new int[n + 1];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);


        return Math.max(
                dfs(nums, 0, n - 2, memo1),
                dfs(nums, 1, n - 1, memo2));
    }

    private int dfs(int[] nums, int start, int end, int[] memo) {
        if (start > end) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }



        return memo[start] = Math.max(
                dfs(nums, start + 2, end, memo) + nums[start],
                dfs(nums, start + 1, end, memo));
    }
}
