package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class BfsTemp_3 {

    class State {
        int node;
        int step;

        public State(int node, int step) {
            this.node = node;
            this.step = step;
        }
    }

    public void bfs(Graph graph, int s) {
        if (s < 0 || s >= graph.size()) {
            return;
        }

        boolean[] visited = new boolean[graph.size()];
        Deque<State> queue = new ArrayDeque<>();
        queue.addLast(new State(s, 0));
        visited[s] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State cur = queue.pollFirst();
                System.out.println("visit: " + cur + ", at step: " + cur.step);

                for (Adjacency_Weight.Edge neighbor : graph.neighbors(cur.node)) {
                    if (visited[neighbor.to]) {
                        continue;
                    }

                    queue.addLast(new State(neighbor.to, cur.step + 1));
                    visited[neighbor.to] = true;
                }
            }
        }
    }
}
