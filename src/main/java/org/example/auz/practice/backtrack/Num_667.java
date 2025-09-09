package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 667. beautiful-arrangement-ii
 * https://leetcode.cn/problems/beautiful-arrangement-ii/description/
 */
public class Num_667 {

    boolean[] visited;

    Deque<Integer> stack = new ArrayDeque<>();

    List<Integer> res = new ArrayList<>();


    public int[] constructArray(int n, int k) {
        visited = new boolean[n + 1];
        dfs(n, k);

        int[] arr = new int[n];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(int n, int k) {
        if (!res.isEmpty()) {
            return;
        }

        if (stack.size() == n) {
            if (check(new ArrayList<>(stack), k)) {
                res = new ArrayList<>(stack);
                return;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            stack.add(i);
            dfs(n, k);
            stack.removeLast();
            visited[i] = false;

        }
    }

    private boolean check(List<Integer> stack, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < stack.size(); i++) {
            set.add(Math.abs(stack.get(i) - stack.get(i - 1)));
        }

        return set.size() == k;
    }

    public static void main(String[] args) {
        Num_667 test = new Num_667();
        test.constructArray(3, 1);
    }


}
