package org.example.auz.practice.dp;

/**
 * 1749. maximum-absolute-sum-of-any-subarray
 * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/
 */
public class Num_1749_1 {

    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int curMin = 0;
        int max = Integer.MIN_VALUE;

        int curMax = 0;
        int min = Integer.MAX_VALUE;
        for (int p : preSum) {
            max = Math.max(max, p - curMin);
            curMin = Math.min(curMin, p);

            min = Math.min(min, p - curMax);
            curMax = Math.max(curMax, p);
        }

        return Math.max(Math.abs(max), Math.abs(min));
    }

}
