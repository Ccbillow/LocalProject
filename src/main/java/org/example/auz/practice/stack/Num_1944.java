package org.example.auz.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1944. Number of Visible People in a Queue
 * https://leetcode.com/problems/number-of-visible-people-in-a-queue/description/?show=1
 */
public class Num_1944 {

    public int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int[] res = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = length - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && stack.peekLast() <= heights[i]) {
                stack.removeLast();
                count++;
            }

            res[i] = stack.isEmpty() ? count : count + 1;

            stack.addLast(heights[i]);
        }
        return res;
    }
}
