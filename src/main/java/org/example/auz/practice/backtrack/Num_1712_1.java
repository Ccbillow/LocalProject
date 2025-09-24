package org.example.auz.practice.backtrack;

/**
 * 1712. ways-to-split-array-into-three-subarrays
 * https://leetcode.cn/problems/ways-to-split-array-into-three-subarrays/description/
 */
public class Num_1712_1 {

    public int waysToSplit(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        long res = 0;

        for (int i = 1; i < preSum.length; i++) {
            for (int j = i + 1; j < preSum.length; j++) {
                int left = preSum[i];
                int mid = preSum[j] - preSum[i];
                int right = preSum[preSum.length - 1] - preSum[j];

                if (left <= mid && mid <= right) {
                    res++;
                }
            }
        }
        return (int) (res % 1_000_000_007);
    }
}
