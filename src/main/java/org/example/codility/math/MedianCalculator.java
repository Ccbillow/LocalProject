package org.example.codility.math;

import java.util.Arrays;

/**
 * 一个函数接收一个整数数组，返回中位数（Median）。
 *
 * 要计算一个整数数组的中位数（Median），可以按照以下规则：
 *
 * 若数组长度为奇数，中位数是排序后中间那个数；
 *
 * 若数组长度为偶数，中位数是排序后中间两个数的平均值。
 */
public class MedianCalculator {

    public static double solution(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        if (length % 2 == 1) {
            return nums[length / 2];
        } else {
            return (nums[length / 2 - 1] + nums[length / 2]) / 2.0;
        }
    }

}
