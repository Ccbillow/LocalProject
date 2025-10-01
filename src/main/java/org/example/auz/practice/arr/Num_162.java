package org.example.auz.practice.arr;

/**
 * \162. find-peak-element
 * https://leetcode.cn/problems/find-peak-element/description/
 */
public class Num_162 {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) << 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
