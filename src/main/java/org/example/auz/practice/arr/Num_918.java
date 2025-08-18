package org.example.auz.practice.arr;

/**
 * 918. Maximum Sum Circular Subarray
 * https://leetcode.com/problems/maximum-sum-circular-subarray/description/?show=1
 */
public class Num_918 {


    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int curMax = 0, maxSum = nums[0];
        int curMin = 0, minSum = nums[0];
        for (int num : nums) {
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);

            total = total + num;
        }

        if (total == minSum) {
            return maxSum;
        } else {
            return Math.max(maxSum, total - minSum);
        }
    }


}
