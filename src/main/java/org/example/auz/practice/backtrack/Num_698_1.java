package org.example.auz.practice.backtrack;

/**
 * 698. partition-to-k-equal-sum-subsets
 *
 * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/description/
 */
public class Num_698_1 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % k != 0) return false;

        int[] bucket = new int[k];
        int target = sum / k;
        return dfs(nums, 0, bucket, target);
    }

    private boolean dfs(int[] nums, int idx, int[] bucket, int target) {
        if (idx == nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[idx] > target) {
                continue;
            }

            bucket[i] = bucket[i] + nums[idx];
            if (dfs(nums, idx + 1, bucket, target)) {
                return true;
            }
            bucket[i] = bucket[i] - nums[idx];
        }
        return false;
    }
}
