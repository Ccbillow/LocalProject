package org.example.auz.practice.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 3067. count-pairs-of-connectable-servers-in-a-weighted-tree-network
 * https://leetcode.cn/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/description/
 */
public class Num_3067 {

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;

        // 1. build graph
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
            graph[to].add(new int[]{from, weight});
        }

        int[] res = new int[n];

        // 2. each node as root
        for (int i = 0; i < n; i++) {
            int childCnt = 0;
            for (int[] neighbor : graph[i]) {
                int nei = neighbor[0];
                int weight = neighbor[1];

                int count = dfs(graph, nei, i, weight, signalSpeed);
                res[i] = res[i] + childCnt * count;
                childCnt = childCnt + count;
            }

        }
        return res;
    }

    /**
     * Returns the number of nodes on the subtree rooted with cur as the distance that meets the divisible signalSpeed
     * @param cur: current node
     * @param parent: parent node
     * @param distance: current node to parent node
     */
    private int dfs(List<int[]>[] graph, int cur, int parent, int distance, int signalSpeed) {
        int cnt = distance % signalSpeed == 0 ? 1 : 0;

        for (int[] neighbor : graph[cur]) {
            int nei = neighbor[0];
            int wei = neighbor[1];
            if (nei == parent) {
                continue;
            }

            cnt = cnt + dfs(graph, nei, cur, wei + distance, signalSpeed);
        }

        return cnt;
    }
}
