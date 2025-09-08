package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. permutations
 *
 * https://leetcode.cn/problems/permutations/description/
 */
public class Num_46 {

    boolean[] visited;
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];

        backtrack(nums, path, visited);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;

            backtrack(nums, path, visited);

            path.removeLast();
            visited[i] = false;
        }
    }
}
