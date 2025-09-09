package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 2203. minimum-weighted-subgraph-with-the-required-paths
 * https://leetcode.cn/problems/minimum-weighted-subgraph-with-the-required-paths/description/
 */
public class Num_2203 {




    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<int[]>[] graph = new ArrayList[n];
        List<int[]>[] rGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            rGraph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
            rGraph[to].add(new int[]{from, weight});
        }

        long[] d1 = dijkstra(n, src1, graph);
        long[] d2 = dijkstra(n, src2, graph);
        long[] d3 = dijkstra(n, dest, rGraph);

        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (d1[i] == Long.MAX_VALUE || d2[i] == Long.MAX_VALUE || d3[i] == Long.MAX_VALUE) {
                continue;
            }
            res = Math.min(res, d1[i] + d2[i] + d3[i]);
        }
        return res == Long.MAX_VALUE ? -1 : res;
    }

    private long[] dijkstra(int n, int source, List<int[]>[] graph) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{source, 0});
        dist[source] = 0;
        while (!pq.isEmpty()) {
            long[] curNode = pq.poll();
            int cur = (int) curNode[0];
            long distFromRoot = curNode[1];

            if (distFromRoot > dist[cur]) continue;

            for (int[] neiNode : graph[cur]) {
                int nei = neiNode[0];
                long neiWeight = neiNode[1];

                long newWeight = distFromRoot + neiWeight;

                if (newWeight < dist[nei]) {
                    dist[nei] = newWeight;
                    pq.add(new long[]{nei, newWeight});
                }
            }
        }
        return dist;
    }
}
