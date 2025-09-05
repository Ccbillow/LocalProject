package org.example.auz.practice.arr;

/**
 * 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 */
public class Num_713_2 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            long sum = 1;
            for (int j = i; j < nums.length; j++) {
                sum = sum * nums[j];
                if (sum < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
