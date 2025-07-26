package org.example.auz.blind75.stack;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * time: O(n^2)
 * space: O(1)
 */
public class Num_42_2 {

    public int trap(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            result = result + Math.min(leftMax, rightMax) - height[i];
        }

        return result;
    }
}
