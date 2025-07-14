package org.example.auz.blind75.arrays;

import sun.nio.cs.ext.MacHebrew;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_11_2 {


    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            max = Math.max(max, h * w);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;

    }

}
