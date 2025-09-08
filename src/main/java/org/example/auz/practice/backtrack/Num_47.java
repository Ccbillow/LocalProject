package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. permutations-ii
 * https://leetcode.cn/problems/permutations-ii/description/
 */
public class Num_47 {

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> track = new ArrayList<>();

    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];

        Arrays.sort(nums);

        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;

            backtrack(nums);

            track.remove(track.size() - 1);
            used[i] = false;
        }
    }
}
