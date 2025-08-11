package org.example.auz.practice.arr;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class Num_26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int fast = 0;
        int slow = 0;

        /*
            1  2  2  2  3  5
            ^^
         */

        while (fast != nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }

            fast++;
        }
        return slow + 1;
    }
}
