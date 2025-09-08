package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. combinations
 * https://leetcode.cn/problems/combinations/description/?show=1
 */
public class Num_77_1 {

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return res;
    }

    private void backtrack(int n, int i, int target) {
        if (track.size() == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int j = i; j <= n; j++) {
            track.add(j);

            backtrack(n, j + 1, target);

            track.remove(track.size() - 1);
        }
    }




}
