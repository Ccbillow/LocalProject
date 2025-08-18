package org.example.auz.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 503. Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class Num_503_1 {

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] arr = new int[2 * length];
        for (int i = 0; i < 2 * length; i++) {
            arr[i] = nums[(i + length) % length];
        }

        int[] res = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peekLast()) {
                stack.removeLast();
            }

            if (i < length) {
                res[i] = stack.isEmpty() ? -1 : stack.peekLast();
            }
            stack.addLast(arr[i]);
        }
        return res;
    }
}
