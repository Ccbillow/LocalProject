package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 494. target-sum
 * https://leetcode.cn/problems/target-sum/description/
 */
public class Num_494_4 {

    int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum - Math.abs(target) < 0 || (sum + target) % 2 == 1) {
            return 0;
        }

        int m = (sum + target) / 2;
        int n = nums.length;

        memo = new int[n][m];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return dfs(n - 1, m, nums);
    }

    private int dfs(int i, int j, int[] nums) {
        if (i < 0) {
            return j == 0 ? 1 : 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = dfs(i - 1, j, nums);
        if (j - nums[i] >= 0) {
            res += dfs(i - 1, j - nums[i], nums);
        }

        return memo[i][j] = res;
    }


}
