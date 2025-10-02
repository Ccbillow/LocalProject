package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 2915. length-of-the-longest-subsequence-that-sums-to-target
 * https://leetcode.cn/problems/length-of-the-longest-subsequence-that-sums-to-target/description/
 */
public class Num_2915_2 {

    int[][] memo;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Integer[] numsArr = nums.toArray(Integer[]::new);

        int n = numsArr.length;

        memo = new int[n][target + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        int res = dfs(n - 1, target, numsArr);
        return res > 0 ? res : -1;
    }

    private int dfs(int i, int j, Integer[] nums) {
        if (i < 0) {
            return j == 0 ? 0 : Integer.MIN_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = dfs(i - 1, j, nums);
        if (j >= nums[i]) {
            res = Math.max(res, dfs(i - 1, j - nums[i], nums) + 1);
        }
        return memo[i][j] = res;
    }
}
