package org.example.auz.practice.str;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/?show=1
 */
public class Num_1658 {

    public int minOperations(int[] nums, int x) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        int target = sum - x;
        if (target < 0) {
            return -1;
        }

        int left = 0;
        int right = 0;

        int val = 0;
        int res = Integer.MAX_VALUE;

        while (right < nums.length) {
            val = val + nums[right];
            right++;

            while (val > target) {
                val = val - nums[left];
                left++;
            }

            if (val == target) {
                res = Math.min(res, left + nums.length - right);
            }
        }
        return res;
    }
}
