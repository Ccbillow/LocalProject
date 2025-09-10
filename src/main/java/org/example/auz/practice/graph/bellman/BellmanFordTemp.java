package org.example.auz.practice.graph.bellman;

import java.util.Arrays;

/**
 * bellman-ford
 *
 * time: O (V * E)
 */
public class BellmanFordTemp {
    class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public int[] bellmanford(int n, Edge[] edges, int src) {
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        dist[src] = 0;

        // n - 1 Relaxation
        for (int i = 0; i < n - 1; i++) {
            boolean update = false;

            for (Edge e : edges) {
                if (dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.weight;
                    path[e.to] = e.from;
                    update = true;
                }
            }

            // no update, exist
            if (!update) {
                break;
            }
        }

        for (Edge e : edges) {
            if (dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.weight < dist[e.to]) {
                // contains negative weight cycle
                return null;
            }
        }
        return dist;
    }
}
