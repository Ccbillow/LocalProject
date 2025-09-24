package org.example.auz.practice.arr;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2333. minimum-sum-of-squared-difference
 * https://leetcode.cn/problems/minimum-sum-of-squared-difference/description/
 */
public class Num_2333_2 {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        Map<Integer, Integer> diff2Count = new HashMap<>();

        int max = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            diff2Count.put(diff, diff2Count.getOrDefault(diff, 0) + 1);
            max = Math.max(max, diff);
        }

        int k = k1 + k2;
        while (k > 0 && !diff2Count.isEmpty()) {
            if (max == 0) {
                break;
            }

            Integer count = diff2Count.get(max);

            if (k >= count) {
                diff2Count.remove(max);
                max = max - 1;
                diff2Count.put(max, diff2Count.getOrDefault(max, 0) + count);
                k = k - count;
            } else {
                diff2Count.put(max, count - k);
                max = max - 1;
                diff2Count.put(max, diff2Count.getOrDefault(max, 0) + k);
                k = 0;
            }
        }

        long res = 0;
        for (Map.Entry<Integer, Integer> entry : diff2Count.entrySet()) {
            long a = entry.getKey();
            long b = entry.getValue();
            res += a * a * b;
        }

        return res;
    }


}
