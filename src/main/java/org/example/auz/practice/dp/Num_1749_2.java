package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 1749. maximum-absolute-sum-of-any-subarray
 * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/
 */
public class Num_1749_2 {

    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int[] maxDp = new int[n + 1];
        int[] minDp = new int[n + 1];
        maxDp[0] = 0;
        minDp[0] = 0;
        for (int i = 1; i <= n; i++) {
            maxDp[i] = Math.max(nums[i - 1], maxDp[i - 1] + nums[i - 1]);
            minDp[i] = Math.min(nums[i - 1], minDp[i - 1] + nums[i - 1]);
        }

        int max = Arrays.stream(maxDp).max().getAsInt();
        int min = Arrays.stream(minDp).min().getAsInt();

        return Math.max(Math.abs(max), Math.abs(min));
    }


}
