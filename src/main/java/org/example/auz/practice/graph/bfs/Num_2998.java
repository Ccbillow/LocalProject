package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * minimum-number-of-operations-to-make-x-and-y-equal
 * https://leetcode.cn/problems/minimum-number-of-operations-to-make-x-and-y-equal/description/
 */
public class Num_2998 {

    public int minimumOperationsToMakeEqual(int x, int y) {
        int n = 10001;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(x);
        boolean[] visited = new boolean[n];
        visited[x] = true;

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.removeFirst();

                if (cur == y) {
                    return res;
                }

                if (cur + 1 < n && !visited[cur + 1]) {
                    q.add(cur + 1);
                    visited[cur + 1] = true;
                }

                if (cur - 1 >= 1 && !visited[cur - 1]) {
                    q.add(cur - 1);
                    visited[cur - 1] = true;
                }

                if (cur % 11 == 0 && !visited[cur / 11]) {
                    q.add(cur / 11);
                    visited[cur / 11] = true;
                }

                if (cur % 5 == 0 && !visited[cur / 5]) {
                    q.add(cur / 5);
                    visited[cur / 5] = true;
                }
            }

            res++;
        }
        return -1;
    }
}
