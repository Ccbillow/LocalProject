package org.example.auz.practice.greedy;

/**
 * 2789. largest-element-in-an-array-after-merge-operations
 * https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/description/?show=1
 */
public class Num_2789_1 {

    public long maxArrayValue(int[] nums) {
        long res = 0;

        int i = nums.length - 1;
        while (i >= 0) {
            long cur = nums[i];
            while (i > 0 && cur >= nums[i - 1]) {
                cur += nums[i - 1];
                i--;
            }
            res = Math.max(res, cur);
            i--;
        }
        return res;
    }
}
