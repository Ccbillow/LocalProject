package org.example.auz.practice.stack;

import java.util.Stack;

public class MonotonicStackTemp {

    public int[] calculateGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // nums: 2  1  3  2  4
        // res:  3  3  4  4 -1
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
