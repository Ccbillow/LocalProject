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

        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (memo[target] != -1) {
            return memo[target];
        }

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            res = res + dfs(nums, target - num);
        }

        return memo[target] = res;
    }


}
