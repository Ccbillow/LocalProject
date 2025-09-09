package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 526. beautiful-arrangement
 * https://leetcode.cn/problems/beautiful-arrangement/description/
 */
public class Num_526 {

    int res = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    boolean[] visited;

    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        dfs(n, 1);
        return res;
    }

    private void dfs(int n, int idx) {
        if (idx > n) {
            res++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if (!(i % idx == 0 || idx % i == 0)) {
                continue;
            }

            stack.add(i);
            visited[i] = true;
            dfs(n, idx + 1);
            stack.removeLast();
            visited[i] = false;
        }
    }


}
