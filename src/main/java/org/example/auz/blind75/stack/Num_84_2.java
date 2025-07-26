package org.example.auz.blind75.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * time: O(n^2)
 * space: O(1)
 */
public class Num_84_2 {
    /*
        [2,1,5,6,2,3]
               ^
             <-l
               r->

     */
    public static int largestRectangleArea(int[] heights) {

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            int height = heights[i];
            while (left > 0) {
                if (heights[left - 1] < height) {
                    break;
                }
                left--;
            }
            while (right < heights.length - 1) {
                if (heights[right + 1] < height) {
                    break;
                }
                right++;
            }
            max = Math.max(max, height * (right - left + 1));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));
    }
}
