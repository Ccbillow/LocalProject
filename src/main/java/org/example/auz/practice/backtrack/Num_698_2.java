package org.example.auz.practice.backtrack;

/**
 * 698. partition-to-k-equal-sum-subsets
 *
 * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/description/
 */
public class Num_698_2 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % k != 0) return false;

        boolean[] visited = new boolean[nums.length];
        int target = sum / k;
        return dfs(k, 0, nums, 0, visited, target);
    }

    private boolean dfs(int k, int bucket, int[] nums, int idx, boolean[] visited, int target) {
        if (k == 0) {
            return true;
        }

        if (bucket == target) {
            return dfs(k - 1, 0, nums, 0, visited, target);
        }

        for (int i = idx; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (bucket + nums[i] > target) {
                continue;
            }

            visited[i] = true;
            bucket = bucket + nums[i];
            if (dfs(k, bucket, nums, i + 1, visited, target)) {
                return true;
            }
            bucket = bucket - nums[i];
            visited[i] = false;
        }
        return false;
    }


}
