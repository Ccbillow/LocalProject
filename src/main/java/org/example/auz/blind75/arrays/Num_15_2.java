package org.example.auz.blind75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/description/
 *
 * time: O(n^3)
 * space: O(1)
 */
public class Num_15_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();


        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(tmp);
                        set.add(tmp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
     }
}
