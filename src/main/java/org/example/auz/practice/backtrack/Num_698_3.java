package org.example.auz.practice.backtrack;

import java.util.Arrays;

/**
 * 698. partition-to-k-equal-sum-subsets
 * <p>
 * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/description/
 */
public class Num_698_3 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;

        int[] bucket = new int[k];

        return dfs(nums, 0, bucket, target);
    }

    private boolean dfs(int[] nums, int idx, int[] bucket, int target) {
        if (idx == nums.length) {
            // If all numbers are placed into buckets, each bucket must equal target
//            for (int b : bucket) {
//                if (b != target) {
//                    return false;
//                }
//            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {

            // !!! Skip if current bucket equals the previous one
            // Reason: choosing either gives the same result
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;

            // cut edge
            if (nums[idx] + bucket[i] > target) continue;

            bucket[i] = bucket[i] + nums[idx];

            if (dfs(nums, idx + 1, bucket, target)) {
                return true;
            }

            bucket[i] = bucket[i] - nums[idx];
        }

        return false;
    }


}
