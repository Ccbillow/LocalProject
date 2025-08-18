package org.example.auz.practice.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */
public class Num_581_2 {

    public int findUnsortedSubarray(int[] nums) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        Deque<Integer> stack1 = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack1.isEmpty() && nums[i] < nums[stack1.peekLast()]) {
                left = Math.min(left, stack1.removeLast());
            }

            stack1.addLast(i);
        }

        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && nums[i] > nums[stack2.peekLast()]) {
                right = Math.max(right, stack2.removeLast());
            }

            stack2.addLast(i);
        }
        if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE) {
            return 0;
        }
        return right - left + 1;
    }
}
