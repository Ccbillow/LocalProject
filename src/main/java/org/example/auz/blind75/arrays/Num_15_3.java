package org.example.auz.blind75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/description/
 *
 * time: O(n^2)
 * space: O(n)
 */
public class Num_15_3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = -nums[i] - nums[j];
                if (map.containsKey(tmp)) {
                    List<Integer> list = Arrays.asList(nums[i], tmp, nums[j]);
                    Collections.sort(list);
                    set.add(list);
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(set);
     }
}
