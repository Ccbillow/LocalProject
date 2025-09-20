package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 377. combination-sum-iv
 * https://leetcode.cn/problems/combination-sum-iv/description/
 */
public class Num_377_3 {

    int[] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);

        return dp(nums, target);
    }

    private int dp(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }

        if (memo[target] != -1) {
            return memo[target];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res + dp(nums, target - nums[i]);
        }

        memo[target] = res;
        return memo[target];
    }
}
