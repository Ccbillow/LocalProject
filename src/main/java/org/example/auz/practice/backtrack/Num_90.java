package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. subsets-ii
 * https://leetcode.cn/problems/subsets-ii/description/
 */
public class Num_90 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);

            backtrack(nums, i + 1);

            path.remove(path.size() - 1);
        }
    }
}
