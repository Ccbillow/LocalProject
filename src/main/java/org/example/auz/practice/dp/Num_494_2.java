package org.example.auz.practice.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. target-sum
 * https://leetcode.cn/problems/target-sum/description/
 */
public class Num_494_2 {

    Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int idx, int target) {
        if (idx == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }

        String key = idx + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = dfs(nums, idx + 1, target + nums[idx]);
        int del = dfs(nums, idx + 1, target - nums[idx]);

        memo.put(key, add + del);
        return add + del;
    }
}
