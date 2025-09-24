package org.example.auz.practice.arr;

/**
 * 2270. number-of-ways-to-split-array
 * https://leetcode.cn/problems/number-of-ways-to-split-array/description/
 */
public class Num_2270_1 {

    public int waysToSplitArray(int[] nums) {
        long[] preSum = new long[nums.length + 1];
        preSum[0] = 0;

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        long sum = 0;
        for (int n : nums) sum += n;

        int res = 0;
        for (int i = 1; i < preSum.length - 1; i++) {
            if (preSum[i] >= sum - preSum[i]) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Num_2270_1 test = new Num_2270_1();

        int[] arr = {10, 4, -8, 7};
        test.waysToSplitArray(arr);
    }
}
