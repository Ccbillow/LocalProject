package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class BfsTemp_2 {

    public void bfs(Graph graph, int s) {
        if (s < 0 || s >= graph.size()) {
            return;
        }

        boolean[] visited = new boolean[graph.size()];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(s);
        visited[s] = true;

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.pollFirst();
                System.out.println("visit: " + cur + ", at step: " + step);

                for (Adjacency_Weight.Edge neighbor : graph.neighbors(cur)) {
                    if (visited[neighbor.to]) {
                        continue;
                    }

                    queue.addLast(neighbor.to);
                    visited[neighbor.to] = true;
                }
            }
            step++;
        }
    }
}
