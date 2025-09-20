package org.example.auz.practice.dp;

/**
 * 2035. partition-array-into-two-arrays-to-minimize-sum-difference
 * https://leetcode.cn/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/
 */
public class Num_2035_2 {

    int res = Integer.MAX_VALUE;
    int sum = 0;

    public int minimumDifference(int[] nums) {
        for (int num : nums) {
            sum += num;
        }

        dfs(nums, 0, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int idx, int count, int pathSum) {
        if (count > nums.length / 2) {
            return;
        }

        if (idx == nums.length) {
            if (count == nums.length / 2) {
                res = Math.min(res, Math.abs(pathSum - (sum - pathSum)));
            }
            return;
        }

        //choose nums[idx]
        dfs(nums, idx + 1, count + 1, pathSum + nums[idx]);

        //not chooes nums[idx]
        dfs(nums, idx + 1, count, pathSum);
    }
}
