package org.example.auz.practice.dp;

import java.util.Map;
import java.util.TreeMap;

/**
 * 3186. maximum-total-damage-with-spell-casting
 * https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/description/
 */
public class Num_3186_1 {

    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> val2Count = new TreeMap<>();
        for (int p : power) {
            val2Count.put(p, val2Count.getOrDefault(p, 0) + 1);
        }

        TreeMap<Integer, Long> dp = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : val2Count.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

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
