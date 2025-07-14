package org.example.auz.blind75.arrays;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * time: O(n^2)
 * space: O(1)
 */
public class Num_11_1 {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tmp = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

}
