package org.example.auz.practice.graph.mst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1584. min-cost-to-connect-all-points
 * https://leetcode.cn/problems/min-cost-to-connect-all-points/description/
 * <p>
 * Prim
 * <p>
 * time:
 * space:
 */
public class Num_1584_2 {

    public int minCostConnectPoints(int[][] points) {
        List<int[]>[] graph = new LinkedList[points.length];

        Arrays.setAll(graph, k -> new LinkedList<>());

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int xi = points[i][0];
                int xj = points[j][0];
                int yi = points[i][1];
                int yj = points[j][1];
                int dist = Math.abs(xi - xj) + Math.abs(yi - yj);
                graph[i].add(new int[]{j, dist});
                graph[j].add(new int[]{i, dist});
            }
        }

        int res = 0;
        int count = 0;
        boolean[] visited = new boolean[graph.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int cur = curNode[0];
            int weight = curNode[1];

            if (count == graph.length) {
                return res;
            }

            if (!visited[cur]) {
                visited[cur] = true;
                count++;
                res = res + weight;

                for (int[] neiNode : graph[cur]) {
                    int nei = neiNode[0];
                    int neiWeight = neiNode[1];

                    if (!visited[nei]) {
                        pq.add(new int[]{nei, neiWeight});
                    }
                }
            }
        }

        return res;
    }


}
