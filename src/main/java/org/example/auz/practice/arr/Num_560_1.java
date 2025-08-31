package org.example.auz.practice.arr;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * time: O(n ^ 3)
 * space: O(1)
 */
public class Num_560_1 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;

                for (int l = i; l <= j; l++) {
                    sum = sum + nums[l];
                }

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
