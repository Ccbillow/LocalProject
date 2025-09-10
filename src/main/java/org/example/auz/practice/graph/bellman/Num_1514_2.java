package org.example.auz.practice.graph.bellman;

import java.util.Arrays;

/**
 * 1514. path-with-maximum-probability
 *
 * https://leetcode.cn/problems/path-with-maximum-probability/description/
 */
public class Num_1514_2 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean update = false;

            for (int j = 0; j < edges.length; j++) {
                int from = edges[j][0];
                int to = edges[j][1];
                double weight = succProb[j];

                if (dist[from] * weight > dist[to]) {
                    dist[to] = dist[from] * weight;
                    update = true;
                }
                if (dist[to] * weight > dist[from]) {
                    dist[from] = dist[to] * weight;
                    update = true;
                }
            }

            if (!update) {
                break;
            }
        }

        return dist[end_node];
    }
}
