package org.example.auz.blind75.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description/
 *
 * time complexity : O(n)
 * space complexity : O(1)
 */
public class Num_169_2 {
    public static int majorityElement(int[] nums) {
        int candicate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candicate = num;
            }

            if (candicate == num) {
                count++;
            } else {
                count--;
            }
        }

        int realCount = 0;
        for (int num : nums) {
            if (candicate == num) {
                realCount++;
            }
        }
        if (realCount > nums.length / 2) {
            return candicate;
        } else {
            throw new RuntimeException("not exist");
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
