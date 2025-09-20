package org.example.auz.practice.dp;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Num_53_3 {

    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;

        int window = 0;
        int res = Integer.MIN_VALUE;

        while (right < nums.length) {
            window = window + nums[right];
            right++;

            res = Math.max(window, res);

            while (window < 0) {
                window = window - nums[left];
                left++;
            }
        }
        return res;
    }
}
