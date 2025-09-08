package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 40. combination-sum-ii
 * <p>
 * https://leetcode.cn/problems/combination-sum-ii/description/
 */
public class Num_40_3 {


    Set<List<Integer>> res = new HashSet<>();

    List<Integer> track = new ArrayList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrack(candidates, 0, target, sum);
        return new ArrayList<>(res);
    }

    private void backtrack(int[] candidates, int cur, int target, int sum) {
        if (target == sum) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (sum > target) {
                break;
            }

            if (i > cur && candidates[i] == candidates[i - 1]) {
                continue;
            }

            sum = sum + candidates[i];
            track.add(candidates[i]);

            backtrack(candidates, i + 1, target, sum);

            track.remove(track.size() - 1);
            sum = sum - candidates[i];
        }
    }

    public static void main(String[] args) {
        Num_40_3 test = new Num_40_3();

        int[] arr = {1, 1, 6};
        test.combinationSum2(arr, 8);

//        int[] arr = {2, 5, 2, 1, 2};
//        test.combinationSum2(arr, 5);
    }

}
