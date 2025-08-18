package org.example.auz.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 503. Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class Num_503_2 {

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % length] >= stack.peekLast()) {
                stack.removeLast();
            }

            res[i % length] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(nums[i % length]);
        }
        return res;
    }
}
