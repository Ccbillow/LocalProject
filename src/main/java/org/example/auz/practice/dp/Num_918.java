package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 918. maximum-sum-circular-subarray
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/description/
 */
public class Num_918 {

    public int maxSubarraySumCircular(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        int max = maxSubArray(nums);
        int min = minSubArray(nums);

        return sum == min ? max : Math.max(max, sum - min);
    }

    int maxSubArray(int[] nums) {
        int cur = Integer.MIN_VALUE / 2;
        int max = Integer.MIN_VALUE / 2;
        for (int a : nums) {
            cur = Math.max(a, a + cur);
            max = Math.max(max, cur);
        }
        return max;
    }

    int minSubArray(int[] nums) {
        int cur = Integer.MAX_VALUE / 2;
        int min = Integer.MAX_VALUE / 2;
        for (int a : nums) {
            cur = Math.min(a, a + cur);
            min = Math.min(min, cur);
        }
        return min;
    }

    public static void main(String[] args) {
        Num_918 test = new Num_918();
        int[] arr = {5, -3, 5};
        test.maxSubarraySumCircular(arr);
    }
}
