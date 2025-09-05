package org.example.auz.practice.graph.dijkstra;

import ch.qos.logback.core.joran.conditional.IfAction;

import java.awt.geom.PathIterator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraTmep {

    int[] shortestPath(List<int[]>[] graph, int start) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] path = new int[graph.length];
        Arrays.fill(path, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int cur = curNode[0];
            int distFromRoot = curNode[1];

            if (distFromRoot > dist[cur]) {
                continue;
            }

            for (int[] neiNode : graph[cur]) {
                int nei = neiNode[0];
                int neiDist = neiNode[1];

                int newDist = distFromRoot + neiDist;

                if (newDist < dist[nei]) {
                    dist[nei] = newDist;
                    path[nei] = cur;
                    pq.add(new int[]{nei, newDist});
                }
            }
        }
        return dist;
    }

    int shortestPath(List<int[]>[] graph, int src, int dest) {
        int n = graph.length;

        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->  a[1] - b[1]);
        pq.add(new int[]{src, 0});
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int cur = curNode[0];
            int distFromRoot = curNode[1];

            // shortest path (point -> point), first time poll from pq
            if (cur == dest) {
                return distFromRoot;
            }

            if (distFromRoot > dist[cur]) {
                continue;
            }

            for (int[] neiNode : graph[cur]) {
                int nei = neiNode[0];
                int neiDist = neiNode[1];

                int newDist = distFromRoot + neiDist;

                if (newDist < dist[nei]) {
                    dist[nei] = newDist;
                    path[nei] = cur;
                    pq.add(new int[]{nei, newDist});
                }
            }
        }

        return -1;
    }

    List<Integer> getPath(int[] path, int src, int dest) {
        List<Integer> res = new ArrayList<>();

        int cur = dest;
        while (cur != src) {
            res.add(cur);
            cur = path[cur];
        }

        Collections.reverse(res);
        return res;
    }

}
