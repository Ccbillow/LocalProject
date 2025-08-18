package org.example.auz.practice.str;

import org.example.auz.blind75.tool.MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?show=1
 */
public class Num_1438 {

    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;

        int res = 0;
        MonotonicQueue<Integer> window = new MonotonicQueue<>();
        while (right < nums.length) {
            window.push(nums[right]);
            right++;

            while (window.max() - window.min() > limit) {
                window.pop();
                left++;
            }

            res = Math.max(res, right - left);
        }
        return res;
    }
}
