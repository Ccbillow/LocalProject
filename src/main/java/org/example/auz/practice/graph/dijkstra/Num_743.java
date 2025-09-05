package org.example.auz.practice.graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 743. Network Delay Time
 *
 * https://leetcode.com/problems/network-delay-time/description/
 */
public class Num_743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : times) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }

        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k - 1, 0});
        dist[k - 1] = 0;

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int cur = curNode[0];
            int weightFromRoot = curNode[1];

            if (weightFromRoot > dist[cur]) continue;

            for (int[] neiNode : graph[cur]) {
                int nei = neiNode[0];
                int neiWeight = neiNode[1];

                int newWeight = weightFromRoot + neiWeight;

                if (newWeight < dist[nei]) {
                    dist[nei] = newWeight;
                    path[nei] = cur;
                    pq.add(new int[]{nei, newWeight});
                }
            }
        }

        int res = -1;
        for (int i = 0; i < dist.length; i++) {
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
