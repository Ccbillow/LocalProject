package org.example.auz.practice.graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.DoubleStream;

public class DijkstraTemp {
    class State{
        int node;
        int distFromStart;

        public State(int node, int distFromStart) {
            this.node = node;
            this.distFromStart = distFromStart;
        }
    }

    int[] dijkstra(int[][] graph, int src) {
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[src] = 0;

        Queue<State> pq = new PriorityQueue<>((a,b) -> {
            return a.distFromStart - b.distFromStart;
        });

        pq.add(new State(src, 0));

        boolean[] visited = new boolean[graph.length];

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curNode = cur.node;
            int curDistFromStart = cur.distFromStart;

            if (visited[curNode]) {
                continue;
            }

            visited[curNode] = true;

            for (int i = 0; i < graph.length; i++) {
                if (graph[curNode][i] <= 0) {
                    continue;
                }

                int newDist = curDistFromStart + graph[curNode][i];
                if (newDist < distTo[i]) {
                    pq.add(new State(i, newDist));
                }
            }

        }
        return distTo;
    }

    int[] dijkstra(Graph graph, int src) {
        int[] distTo = new int[graph.size()];
        Arrays.fill(distTo, -1);

        Queue<State> pq = new PriorityQueue<>((a,b) -> {
            return a.distFromStart - b.distFromStart;
        });

        pq.add(new State(src, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curNode = cur.node;
            int curDistFromStart = cur.distFromStart;

            if (distTo[curNode] != -1) {
                continue;
            }

            distTo[curNode] = curDistFromStart;

            for (Adjacency_Weight.Edge e : graph.neighbors(curNode)) {
                int nxt = e.to;
                int nxtDistFromStart = curDistFromStart + e.weight;
                if (distTo[nxt] != -1) {
                    continue;
                }

                pq.add(new State(nxt, nxtDistFromStart));
            }

        }
        return distTo;
    }

    int dijkstra(Graph graph, int src, int dest) {
        int[] distTo = new int[graph.size()];
        Arrays.fill(distTo, -1);

        Queue<State> pq = new PriorityQueue<>((a,b) -> {
            return a.distFromStart - b.distFromStart;
        });

        pq.add(new State(src, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curNode = cur.node;
            int curDistFromStart = cur.distFromStart;

            if (distTo[curNode] != -1) {
                continue;
            }

            distTo[curNode] = curDistFromStart;

            if (curNode == dest) {
                return curDistFromStart;
            }

            for (Adjacency_Weight.Edge e : graph.neighbors(curNode)) {
                int nxt = e.to;
                int nxtDistFromStart = curDistFromStart + e.weight;
                if (distTo[nxt] != -1) {
                    continue;
                }

                pq.add(new State(nxt, nxtDistFromStart));
            }

        }
        return -1;
    }
}
