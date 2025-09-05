package org.example.auz.practice.graph.dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 787. cheapest-flights-within-k-stops
 * https://leetcode.cn/problems/cheapest-flights-within-k-stops/description/
 */
public class Num_787_1 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new LinkedList[n];
        Arrays.setAll(graph, g -> new LinkedList<>());
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int weight = flight[2];
            graph[from].add(new int[]{to, weight});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0, 0});

        int[] minSteps = new int[n];
        Arrays.fill(minSteps, Integer.MAX_VALUE);


        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int cur = curNode[0];
            int cost = curNode[1];
            int step = curNode[2];

            if (cur == dst) {
                return cost;
            }

            if (step > k) {
                continue;
            }

            if (step >= minSteps[cur]) continue;
            minSteps[cur] = step;

            for (int[] neiNode : graph[cur]) {
                int nei = neiNode[0];
                int neiCost = neiNode[1];
                pq.add(new int[]{nei, cost + neiCost, step + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Num_787_1 test = new Num_787_1();
        int[][] arr = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println(test.findCheapestPrice(4, arr, 0, 3, 1));
    }
}



