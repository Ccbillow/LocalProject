package org.example.auz.practice.arr;

/**
 * 2256. minimum-average-difference
 * https://leetcode.cn/problems/minimum-average-difference/description/
 */
public class Num_2256 {

    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;

        long[] preSum = new long[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int idx = 0;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long left = preSum[i + 1] / (i + 1);
            long right = 0;
            if (i != n - 1) {
                right = (preSum[n] - preSum[i + 1]) / (n - i - 1);
            }

            long diff = Math.abs(left - right);
            if (diff < min) {
                min = diff;
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        Num_2256 test = new Num_2256();
        int[] arr = {4, 2, 0};
        System.out.println(test.minimumAverageDifference(arr));
    }
}
