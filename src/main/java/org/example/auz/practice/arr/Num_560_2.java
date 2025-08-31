package org.example.auz.practice.arr;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * time: O(n ^ 2)
 * space: O(1)
 */
public class Num_560_2 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int preSum = 0;

            for (int j = i; j < nums.length; j++) {
                preSum = preSum + nums[j];
                if (preSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
