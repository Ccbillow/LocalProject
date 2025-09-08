package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 40. combination-sum-ii
 *
 * https://leetcode.cn/problems/combination-sum-ii/description/
 */
public class Num_40_1 {


    List<List<Integer>> res = new ArrayList<>();

    List<Integer> track = new ArrayList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrack(candidates, 0, target, sum);
        return res;
    }

    private void backtrack(int[] candidates, int cur, int target, int sum) {
        if (target == sum) {
            if (canAdd(res, track)) {
                res.add(new ArrayList<>(track));
            }
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (sum < target) {
                sum = sum + candidates[i];
                track.add(candidates[i]);

                backtrack(candidates, i + 1, target, sum);

                track.remove(track.size() - 1);
                sum = sum - candidates[i];
            }
        }
    }

    private boolean canAdd(List<List<Integer>> res, List<Integer> track) {
        int canAdd = 0;

        for (List<Integer> re : res) {
            if (re.size() != track.size()) {
                canAdd++;
                continue;
            }

            for (int i = 0; i < re.size(); i++) {
                if (!re.get(i).equals(track.get(i))) {
                    canAdd++;
                    break;
                }
            }
        }
        return canAdd == res.size();
    }

    public static void main(String[] args) {
        Num_40_1 test = new Num_40_1();

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        test.combinationSum2(arr, 8);

//        int[] arr = {2, 5, 2, 1, 2};
//        test.combinationSum2(arr, 5);
    }

}
