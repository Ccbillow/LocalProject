package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 924. Minimize Malware Spread
 * https://leetcode.com/problems/minimize-malware-spread/description/
 */
public class Num_924_3 {

    int n;
    int[] component;
    int[] size;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        n = graph.length;
        component = new int[n];
        Arrays.fill(component, -1);
        size = new int[n];

        int id = 0;
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                bfs(graph, i, id);
                id++;
            }
        }

        int[] infectCount = new int[id];
        for (int i : initial) {
            infectCount[component[i]]++;
        }

        Arrays.sort(initial);
        int res = initial[0];
        int max = -1;

        for (int i : initial) {
            int compId = component[i];

            if (infectCount[compId] == 1) {
                if (size[compId] > max) {
                    max = size[compId];
                    res = i;
                }
            }
        }

        return res;
    }

    private void bfs(int[][] graph, int start, int id) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(start);

        component[start] = id;
        size[id] = 1;

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();
            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1 && component[i] == -1) {
                    component[i] = id;
                    size[id]++;
                    q.addLast(i);
                }
            }
        }
    }
}
