package org.example.auz.practice.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 416. partition-equal-subset-sum
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class Num_416_4 {

    int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        int n = nums.length;

        memo = new int[n][target + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return dfs(nums, n - 1, target);
    }

    private boolean dfs(int[] nums, int i, int target) {
        if (i < 0) {
            return target == 0;
        }

        if (memo[i][target] != -1) {
            return memo[i][target] == 1;
        }

        boolean res;
        if (target - nums[i] < 0) {
            res = dfs(nums, i - 1, target);
        } else {
            res = dfs(nums, i - 1, target) || dfs(nums, i - 1, target - nums[i]);
        }

        memo[i][target] = res ? 1 : 0;
        return res;
    }


}
