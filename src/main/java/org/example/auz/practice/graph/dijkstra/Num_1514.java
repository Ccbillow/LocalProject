package org.example.auz.practice.graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1514. Path with Maximum Probability
 * https://leetcode.com/problems/path-with-maximum-probability/description/
 */
public class Num_1514 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        double[] dist = new double[n];
        Arrays.fill(dist, Double.MIN_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight));
        pq.add(new Node(start_node, 1));
        dist[start_node] = 1;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.node;
            double weightFromRoot = curNode.weight;

            if (cur == end_node) {
                return weightFromRoot;
            }

            for (Node neiNode : graph[cur]) {
                int nei = neiNode.node;
                double neiWeight = neiNode.weight;

                double newWeight = weightFromRoot * neiWeight;

                if (newWeight > dist[nei]) {
                    dist[nei] = newWeight;
                    pq.add(new Node(nei, newWeight));
                }
            }
        }

        return 0;
    }

    class Node {
        int node;
        double weight;

        public Node(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
