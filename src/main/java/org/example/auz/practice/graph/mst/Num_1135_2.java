package org.example.auz.practice.graph.mst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 1135. Connecting Cities With Minimum Cost
 * <p>
 * Prim
 *
 * edge:m  node:n
 * time: O(m log n)
 * space: O(m + n)
 */
public class Num_1135_2 {

    public int minimumCost(int n, int[][] connections) {
        // build graph
        List<int[]>[] graph = new LinkedList[n];
        Arrays.setAll(graph, Key -> new LinkedList<int[]>());
        for (int[] edge : connections) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
            graph[to].add(new int[]{from, weight});
        }

        int sum = 0;
        boolean[] visited = new boolean[graph.length];

        // pq: save min edge
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            // get min node from pq to mst
            int[] curNode = pq.poll();
            int cur = curNode[0];
            int cost = curNode[1];

            if (visited[cur]) {
                continue;
            }

            sum = sum + cost;
            visited[cur] = true;

            for (int[] neiNode : graph[cur]) {
                int nei = neiNode[0];
                int neiCost = neiNode[1];

                // add all neighbor to pq, for next iteration
                if (!visited[nei]) {
                    pq.add(new int[]{nei, neiCost});
                }
            }
        }

        // if any node not visit, means not connect
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return -1;
            }
        }

        return sum;
    }


}
