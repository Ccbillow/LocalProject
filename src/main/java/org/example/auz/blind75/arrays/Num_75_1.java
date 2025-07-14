package org.example.auz.blind75.arrays;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_75_1 {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int i = 0;
        while (count0 > 0) {
            nums[i] = 0;
            i++;
            count0--;
        }
        while (count1 > 0) {
            nums[i] = 1;
            i++;
            count1--;
        }
        while (count2 > 0) {
            nums[i] = 2;
            i++;
            count2--;
        }
    }
}
