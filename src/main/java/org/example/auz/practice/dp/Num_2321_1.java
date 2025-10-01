package org.example.auz.practice.dp;

/**
 * 2321. maximum-score-of-spliced-array
 * https://leetcode.cn/problems/maximum-score-of-spliced-array/description/
 */
public class Num_2321_1 {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int sum1 = 0, sum2 = 0;

        int[] diff1 = new int[n];
        int[] diff2 = new int[n];

        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];

            diff1[i] = nums1[i] - nums2[i];
            diff2[i] = nums2[i] - nums1[i];
        }

        int max1 = sum1 + maxSubArray(diff2);
        int max2 = sum2 + maxSubArray(diff1);
        return Math.max(max1, max2);
    }

    int maxSubArray(int[] arr) {
        int cur = 0;
        int max = 0;
        for (int a : arr) {
            cur = Math.max(cur, cur + a);
            max = Math.max(max, cur);
        }
        return max;
    }
}
