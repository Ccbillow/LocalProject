package org.example.auz.practice.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/description/
 */
public class Num_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> val2Greater = new HashMap<>();
        int[] greater = nextGreater(nums2);
        for (int i = 0; i < nums2.length; i++) {
            val2Greater.put(nums2[i], greater[i]);
        }


        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = val2Greater.get(nums1[i]);
        }
        return res;
    }

    private int[] nextGreater(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = res.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }
        return res;
    }
}
