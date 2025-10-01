package org.example.auz.practice.dp;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Num_53_6_1 {

    public int[] maxSubArray(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int start = 0, end = 0;
        int minIndex = 0;

        for (int i = 1; i <= nums.length; i++) {
            if (preSum[i] - min > res) {
                res = preSum[i] - min;
                start = minIndex;
                end = i - 1;
            }

            if (preSum[i] < min) {
                min = preSum[i];
                minIndex = i;
            }
        }
        return new int[]{res, start, end};
    }
}
