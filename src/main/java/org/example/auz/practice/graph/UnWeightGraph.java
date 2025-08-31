package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class UnWeightGraph {

    int[] findShortestPath(int[][] graph, int src) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length];
        int[] path = new int[graph.length];
        Arrays.fill(dist, -1);
        Arrays.fill(path, -1);

        q.add(src);
        visited[src] = true;
        dist[src] = 0;

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            for (int nei : graph[cur]) {
                if (visited[nei]) {
                    continue;
                }

                visited[nei] = true;
                dist[nei] = dist[cur] + 1;
                path[nei] = cur;
                q.addLast(nei);
            }

        }
        return dist;
    }

    int[] findShortestPath(List<List<Integer>> graph, int src) {
        int n = graph.size();

        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, -1);
        Arrays.fill(path, -1);

        q.add(src);
        visited[src] = true;
        dist[src] = 0;

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            for (int nei : graph.get(cur)) {
                if (visited[nei]) {
                    continue;
                }

                visited[nei] = true;
                dist[nei] = dist[cur] + 1;
                path[nei] = cur;
                q.addLast(nei);
            }

        }
        return dist;
    }

    int findShortestPath(int[][] graph, int src, int dest) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, -1);
        Arrays.fill(path, -1);

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(src);
        dist[src] = 0;
        visited[src] = true;

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();

            if (cur == dest) {
                return dist[cur];
            }

            for (int nei : graph[cur]) {
                if (visited[nei]) {
                    continue;
                }

                q.addLast(nei);
                visited[nei] = true;
                dist[nei] = dist[cur] + 1;
                path[nei] = cur;
            }
        }

        return -1;
    }

    int findShortestPath(List<List<Integer>> graph, int src, int dest) {
        int n = graph.size();

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, -1);
        Arrays.fill(path, -1);

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(src);
        dist[src] = 0;
        visited[src] = true;

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            if (cur == dest) {
                return dist[cur];
            }

            for (int nei : graph.get(cur)) {
                if (visited[nei]) {
                    continue;
                }

                q.addLast(nei);
                visited[nei] = true;
                dist[nei] = dist[cur] + 1;
                path[nei] = cur;
            }
        }

        return -1;
    }

    List<Integer> path(int[] path, int src, int dest) {
        List<Integer> res = new ArrayList<>();

        int i = dest;
        while (i != -1) {
            res.add(i);
            i = path[i];
        }
        Collections.reverse(res);

        if (res.get(0) != src) {
            return new LinkedList<>();
        }
        return res;
    }
}
