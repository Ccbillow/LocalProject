package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 1191. k-concatenation-maximum-sum
 * https://leetcode.cn/problems/k-concatenation-maximum-sum/description/
 */
public class Num_1191_2 {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1_000_000_007;

        if (k == 1) {
            return (int) maxSubArray(arr, 1);
        }

        long ans = maxSubArray(arr, 2);
        int s = 0;
        for (int a : arr) {
            s += a;
        }
        ans += (long) Math.max(s, 0) * (k - 2);
        return (int) (ans % mod);
    }

    public long maxSubArray(int[] nums, int repeat) {
        int n = nums.length;

        int cur = 0;
        int max = 0;
        for (int i = 0; i < n * repeat; i++) {
            cur = Math.max(nums[i % n], cur + nums[i % n]);
            max = Math.max(max, cur);
        }
        return max;
    }
}
