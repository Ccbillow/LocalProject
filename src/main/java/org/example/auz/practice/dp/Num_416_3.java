package org.example.auz.practice.dp;

/**
 * 416. partition-equal-subset-sum
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class Num_416_3 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        int n = nums.length;

        return dfs(nums, n - 1, target);
    }

    private boolean dfs(int[] nums, int i, int target) {
        if (i < 0) {
            return target == 0;
        }

        if (target - nums[i] < 0) {
            return dfs(nums, i - 1, target);
        } else {
            return dfs(nums, i - 1, target) || dfs(nums, i - 1, target - nums[i]);
        }
    }


}
