package org.example.auz.practice.graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 787. Cheapest Flights Within K Stops
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 */
public class Num_787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph[from].add(new int[]{to, price});
        }

        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0, 0});
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int cur = curNode[0];
            int priceFromRoot = curNode[1];
            int step = curNode[2];

            if (cur == dst) {
                return priceFromRoot;
            }

            if (step > k) continue;

            for (int[] neiNode : graph[cur]) {
                int nei = neiNode[0];
                int neiPrice = neiNode[1];

                int newPrice = priceFromRoot + neiPrice;

                if (newPrice < dist[nei][step + 1]) {
                    dist[nei][step + 1] = newPrice;
                    pq.add(new int[]{nei, newPrice, step + 1});
                }
            }
        }
        return -1;
    }
}
