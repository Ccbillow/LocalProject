package org.example.auz.practice.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class Num_560 {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> val2Count = new HashMap<>();
        int res = 0;

        for (int i = 0; i < preSum.length; i++) {
            int val = preSum[i] - k;
            res = res + val2Count.getOrDefault(val, 0);
            val2Count.put(preSum[i],val2Count.getOrDefault(preSum[i], 0) + 1);
        }
        return res;
    }
}
