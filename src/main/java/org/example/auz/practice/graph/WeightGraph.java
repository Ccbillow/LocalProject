package org.example.auz.practice.graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeightGraph {

    class State {
        int node;
        int weight;

        public State(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    int[] findShortestPath(int[][] graph, int src) {
        int n = graph.length;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.weight - b.weight;
        });
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, 0);

        pq.offer(new State(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            State curNode = pq.poll();
            int cur = curNode.node;
            int weight = curNode.weight;

            for (int nei : graph[cur]) {
                int newWeight = dist[cur] + weight;

                if (newWeight < dist[nei]) {
                    dist[nei] = newWeight;
                    path[nei] = cur;
                    pq.offer(new State(nei, newWeight));
                }
            }
        }

        return dist;
    }
}
