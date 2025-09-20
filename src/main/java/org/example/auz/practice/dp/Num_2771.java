package org.example.auz.practice.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 2771. longest-non-decreasing-subarray-from-two-arrays
 *
 * https://leetcode.cn/problems/longest-non-decreasing-subarray-from-two-arrays/description/
 */
public class Num_2771 {

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int[] dp1 = new int[nums1.length];
        int[] dp2 = new int[nums2.length];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] >= nums1[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp1[i - 1] + 1);
            }
            if (nums1[i] >= nums2[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp2[i - 1] + 1);
            }

            if (nums2[i] >= nums2[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp2[i - 1] + 1);
            }
            if (nums2[i] >= nums1[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp1[i - 1] + 1);
            }
        }

        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < dp1.length; i++) {
            max1 = Math.max(max1, dp1[i]);
        }
        for (int i = 0; i < dp2.length; i++) {
            max2 = Math.max(max2, dp2[i]);
        }
        return Math.max(max1, max2);
    }
}
