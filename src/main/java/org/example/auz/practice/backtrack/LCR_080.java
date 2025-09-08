package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LCR 080. 组合
 * https://leetcode.cn/problems/uUsW3B/description/?show=1
 */
public class LCR_080 {

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    private void dfs(int n, int k, int idx) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = idx; i <= n; i++) {
            stack.addLast(i);
            dfs(n, k, i + 1);
            stack.removeLast();
        }
    }


}
