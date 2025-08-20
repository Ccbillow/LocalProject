package org.example.auz.practice.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/
 */
public class Num_525 {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
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
}
