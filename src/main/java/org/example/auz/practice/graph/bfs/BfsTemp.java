package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BfsTemp {

    int[] shortestPath(List<Integer>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] path = new int[graph.length];
        Arrays.fill(path, -1);

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(start);

        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.removeFirst();

                for (Integer nei : graph[cur]) {
                    if (!visited[nei]) {
                        q.add(nei);
                        visited[nei] = true;
                        dist[nei] = dist[cur] + 1;
                        path[nei] = cur;
                    }
                }
            }
        }

        return dist;
    }
}
