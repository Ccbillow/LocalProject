package org.example.auz.practice.graph;

import org.example.auz.blind75.tool.Vertex;

import java.util.ArrayDeque;
import java.util.Deque;

public class BfsTemp_1 {

    public void bfs(Graph graph, int s) {
        if (s < 0 || s >= graph.size()) {
            return;
        }

        boolean[] visited = new boolean[graph.size()];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            Integer cur = queue.pollFirst();
            for (Adjacency_Weight.Edge neighbor : graph.neighbors(cur)) {
                if (visited[neighbor.to]) {
                    continue;
                }

                queue.addLast(neighbor.to);
                visited[neighbor.to] = true;
            }
        }
    }
}
