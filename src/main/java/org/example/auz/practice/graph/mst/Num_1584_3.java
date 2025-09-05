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
public class Num_1584_3 {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = -1;

            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    continue;
                }

                if (cur == -1 || minDist[j] < minDist[cur]) {
                    cur = j;
                }
            }

            res = res + minDist[cur];
            visited[cur] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(points[cur][0] - points[j][0]) + Math.abs(points[cur][1] - points[j][1]);
                    minDist[j] = Math.min(minDist[j], dist);
                }
            }
        }
        return res;
    }


}
