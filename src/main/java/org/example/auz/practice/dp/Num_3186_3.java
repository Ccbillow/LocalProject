package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 3186. maximum-total-damage-with-spell-casting
 * https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/description/
 */
public class Num_3186_3 {

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> val2Count = new HashMap<>();
        for (int p : power) {
            val2Count.put(p, val2Count.getOrDefault(p, 0) + 1);
        }

        int n = val2Count.size();
        int[] arr = new int[n];
        int idx = 0;
        for (Integer val : val2Count.keySet()) {
            arr[idx] = val;
            idx++;
        }
        Arrays.sort(arr);

        TreeMap<Integer, Long> dp = new TreeMap<>();
        for (int val : arr) {
            int count = val2Count.get(val);

            Integer valA = dp.floorKey(val - 3);
            Integer valB = dp.floorKey(val - 2);
            Integer valC = dp.floorKey(val - 1);
            long a = (valA == null ? 0 : dp.get(valA)) + (long) val * count;
            long b = valB == null ? 0 : dp.get(valB);
            long c = valC == null ? 0 : dp.get(valC);

            long max = Math.max(a, Math.max(b, c));
            dp.put(val, max);
        }
        return dp.get(dp.lastKey());
    }
}
