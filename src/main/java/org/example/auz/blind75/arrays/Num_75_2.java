package org.example.auz.blind75.arrays;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_75_2 {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int tmp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = tmp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int tmp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = tmp;
                high--;
            }
        }
    }
}
