package org.example.auz.practice.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 */
public class Num_523 {

    /*
        (preSum[i] - preSum[j]) % k == 0
        preSum[i] % k = preSum[j] % k
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> val2Index = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            int val = preSum[i] % k;
            if (!val2Index.containsKey(val)) {
                val2Index.put(val, i);
            }
        }

        for (int j = 1; j < preSum.length; j++) {
            int need = preSum[j] % k;
            if (val2Index.containsKey(need)) {
                if (j - val2Index.get(need) >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
