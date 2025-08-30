package org.example.auz.practice.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/description/?show=1
 */
public class Num_368 {

    List<Integer> maxSubset = new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return maxSubset;
    }

    private void backtrack(int[] nums, List<Integer> current, int start) {
        if (current.size() + (nums.length - start) <= maxSubset.size()) return;

        if (current.size() > maxSubset.size()) {
            maxSubset = new ArrayList<>(current);
        }

        for (int i = start; i < nums.length; i++) {
            if (current.isEmpty() || nums[i] % current.get(current.size() - 1) == 0) {
                current.add(nums[i]);
                backtrack(nums, current, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
