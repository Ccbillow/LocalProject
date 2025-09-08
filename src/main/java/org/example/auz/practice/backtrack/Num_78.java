package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. subsets
 *
 * https://leetcode.cn/problems/subsets/description/
 */
public class Num_78 {

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int cur) {
        res.add(new ArrayList<>(track));

        if (track.size() == nums.length) {
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            track.add(nums[i]);

            backtrack(nums, i + 1);

            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Num_78 test = new Num_78();
        test.subsets(nums);
    }
}
