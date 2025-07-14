package org.example.auz.blind75.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 *
 * desc: https://leetcode.com/problems/two-sum/description/
 */
public class Num1 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
