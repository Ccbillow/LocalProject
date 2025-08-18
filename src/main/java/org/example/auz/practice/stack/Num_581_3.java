package org.example.auz.practice.stack;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */
public class Num_581_3 {

    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int right = -1;

        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            if (nums[i] < leftMax) {
                right = i;
            }
        }

        int rightMin = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightMin = Math.min(rightMin, nums[i]);
            if (nums[i] > rightMin) {
                left = i;
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }
}
