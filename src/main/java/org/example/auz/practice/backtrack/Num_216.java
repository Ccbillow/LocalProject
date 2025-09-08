package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. combination-sum-iii
 * https://leetcode.cn/problems/combination-sum-iii/description/
 */
public class Num_216 {

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> stack = new ArrayDeque<>();

    int sum = 0;
    int cur = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return res;
    }

    private void dfs(int k, int n, int idx) {
        if (cur == k && sum == n) {
            res.add(new ArrayList<>(stack));
            return;
        }

        if (sum > n || cur > n) {
            return;
        }

        for (int i = idx; i <= 9; i++) {
            stack.add(i);
            cur++;
            sum = sum + i;
            dfs(k, n, i + 1);
            sum = sum - i;
            stack.removeLast();
            cur--;
        }
    }

    public static void main(String[] args) {
        Num_216 test = new Num_216();
//        test.combinationSum3(3, 7);
        test.combinationSum3(3, 9);
    }

}
