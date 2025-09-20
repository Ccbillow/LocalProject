package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 805. split-array-with-same-average
 * https://leetcode.cn/problems/split-array-with-same-average/description/
 */
public class Num_805_1 {


    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (n == 1) {
            return false;
        }

        int mid = n / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);

        Map<Integer, Set<Integer>> leftMap = new HashMap<>();
        Map<Integer, Set<Integer>> rightMap = new HashMap<>();
        generate(left, 0, 0, 0, leftMap);
        generate(right, 0, 0, 0, rightMap);

        for (int k = 1; k < n / 2; k++) {
            if ((sum * k) % n != 0) {
                continue;
            }

            int target = sum * k / n;

            int minLeft = Math.max(0, k - right.length);
            int maxLeft = Math.min(k, left.length);

            for (int leftCount = minLeft; leftCount <= maxLeft; leftCount++) {
                int rightCount = k - leftCount;

                Set<Integer> leftSums = leftMap.getOrDefault(leftCount, Collections.emptySet());
                Set<Integer> rightSums = rightMap.getOrDefault(rightCount, Collections.emptySet());

                for (Integer leftSum : leftSums) {
                    int need = target - leftSum;
                    if (rightSums.contains(need)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void generate(int[] arr, int idx, int count, int sum, Map<Integer, Set<Integer>> map) {
        if (idx == arr.length) {
            map.computeIfAbsent(count, x -> new HashSet<>()).add(sum);
            return;
        }

        generate(arr, idx + 1, count + 1, count + arr[idx], map);

        generate(arr, idx + 1, count, sum, map);
    }


}
