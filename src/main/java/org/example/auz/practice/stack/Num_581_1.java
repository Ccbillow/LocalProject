package org.example.auz.practice.stack;

import java.util.Arrays;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */
public class Num_581_1 {

    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (tmp[i] != nums[i]) {
                left = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (tmp[i] != nums[i]) {
                right = i;
                break;
            }
        }

        if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
            return 0;
        }
        return right - left + 1;
    }
}
