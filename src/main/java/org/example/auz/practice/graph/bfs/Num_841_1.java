package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 841. Keys and Rooms
 *
 * https://leetcode.com/problems/keys-and-rooms/description/
 */
public class Num_841_1 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = rooms.get(i);
        }

        boolean[] visited = new boolean[n];

        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer cur = q.removeFirst();

                for (Integer nei : graph[cur]) {
                    if (visited[nei]) {
                        continue;
                    }

                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }

        boolean res = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res = false;
            }
        }
        return res;
    }
}
