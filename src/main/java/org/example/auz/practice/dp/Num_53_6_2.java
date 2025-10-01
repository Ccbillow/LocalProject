package org.example.auz.practice.dp;

/**
 * Minimum Subarray
 */
public class Num_53_6_2 {

    public int maxSubArray(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int p : preSum) {
            res = Math.min(res, p - max);
            max = Math.max(p, max);
        }
        return res;
    }
}
