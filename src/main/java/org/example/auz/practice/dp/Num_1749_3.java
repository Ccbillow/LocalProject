package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 1749. maximum-absolute-sum-of-any-subarray
 * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/
 */
public class Num_1749_3 {

    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int max = 0;
        int min = 0;
        for (int p : preSum) {
            if (p > max) {
                max = p;
            }
            if (p < min) {
                min = p;
            }
        }
        return max - min;
    }


}
