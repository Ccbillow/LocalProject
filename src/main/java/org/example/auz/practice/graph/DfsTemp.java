package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class DfsTemp {

    int[][] metrix;
    List<List<Integer>> table;
    boolean[] visited;

    public DfsTemp(int m, int n) {
        metrix = new int[m][n];
        table = new ArrayList<>();
        visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            table.add(new ArrayList<>());
        }
    }

    void traverse(int[][] metrix, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        for (int nei : metrix[i]) {
            if (visited[nei]) {
                continue;
            }

            traverse(metrix, nei, visited);
        }
    }

    void traverse(List<List<Integer>> table, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        for (int nei : table.get(i)) {
            if (visited[nei]) {
                continue;
            }

            traverse(table, nei, visited);
        }
    }
}
