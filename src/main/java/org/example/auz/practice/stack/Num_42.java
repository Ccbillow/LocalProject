package org.example.auz.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/?show=1
 */
public class Num_42 {

    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0;
        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                Integer low = stack.pollLast();
                if (stack.isEmpty()) {
                    break;
                }

                Integer left = stack.peekLast();
                int w = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[low];
                res = res + w * h;
            }

            stack.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }
}
