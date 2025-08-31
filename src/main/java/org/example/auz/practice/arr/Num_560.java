package org.example.auz.practice.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class Num_560 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> val2Count = new HashMap<>();
        int count = 0;

        for (int i = 0; i < preSum.length; i++) {
            int need = preSum[i] - k;
            if (val2Count.containsKey(need)) {
                count = count + val2Count.get(need);
            }

            if (!val2Count.containsKey(preSum[i])) {
                val2Count.put(preSum[i], 1);
            } else {
                val2Count.put(preSum[i], val2Count.get(preSum[i]) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Num_560 test = new Num_560();
        int[] arr = {1, 1, 1};
        System.out.println(test.subarraySum(arr, 2));
    }
}
