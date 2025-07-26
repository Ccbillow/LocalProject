package org.example.auz.blind75.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_84_1 {
    /*
        [2,1,5,6,2,3]
                 ^
         i: 4
         index: 3
         stack: 1 2
     */
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int index = stack.pollLast();
                int height = heights[index];
                int width = stack.isEmpty() ? 0 : i - stack.peekLast() - 1;
                max = Math.max(max, height * width);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pollLast();
            int height = heights[index];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peekLast() - 1;
            max = Math.max(max, height * width);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));
    }
}
