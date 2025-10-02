package org.example.auz.practice.dp;

/**
 * 494. target-sum
 * https://leetcode.cn/problems/target-sum/description/
 */
public class Num_494_1 {


    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return res;
    }

    private void dfs(int[] nums, int idx, int target) {
        if (idx == nums.length) {
            if (target == 0) {
                res++;
            }
            return;
        }

        dfs(nums, idx + 1, target + nums[idx]);
        dfs(nums, idx + 1, target - nums[idx]);
    }


}
