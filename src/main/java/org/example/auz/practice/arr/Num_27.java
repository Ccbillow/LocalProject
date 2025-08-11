package org.example.auz.practice.arr;

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/description/
 */
public class Num_27 {

    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }


}
