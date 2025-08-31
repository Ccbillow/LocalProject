package org.example.auz.practice.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/
 */
public class Num_525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                tmp[i] = -1;
            } else {
                tmp[i] = 1;
            }
        }

        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + tmp[i - 1];
        }

        Map<Integer, Integer> val2Index = new HashMap<>();
        int res = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (!val2Index.containsKey(preSum[i])) {
                val2Index.put(preSum[i], i);
            } else {
                res = Math.max(res, i - val2Index.get(preSum[i]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        Num_525 test = new Num_525();
        test.findMaxLength(arr);
    }
}
