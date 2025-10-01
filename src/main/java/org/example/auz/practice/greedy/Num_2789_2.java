package org.example.auz.practice.greedy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 2789. largest-element-in-an-array-after-merge-operations
 * https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/description/?show=1
 */
public class Num_2789_2 {

    public long maxArrayValue(int[] nums) {
        Deque<Long> stack = new ArrayDeque<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            long cur = nums[i];
            while (!stack.isEmpty() && cur <= stack.peekLast()) {
                cur = cur + stack.removeLast();
            }
            stack.addLast(cur);
        }

        long res = 0;
        while (!stack.isEmpty()) {
            res = Math.max(res, stack.removeLast());
        }
        return res;
    }

    public static void main(String[] args) {
        Num_2789_2 test = new Num_2789_2();

        int[] nums = {2, 3, 7, 9, 3};
        test.maxArrayValue(nums);
    }
}
