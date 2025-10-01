package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 377. combination-sum-iv
 * https://leetcode.cn/problems/combination-sum-iv/description/
 */
public class Num_377_5 {

    int res = 0;

    public int combinationSum4(int[] nums, int target) {
        dfs(nums, target);
        return res;
    }

    void dfs(int[] nums, int target) {
        if (target == 0) {
            res++;
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            dfs(nums, target - num);
        }
    }

}
