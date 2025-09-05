package org.example.auz.practice.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Num_207_3 {

    boolean cycle = false;
    boolean[] visited;

    Set<Integer> set;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] p : prerequisites) {
            int from = p[0];
            int to = p[1];
            graph[from].add(to);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                set = new HashSet<>();
                dfs(graph, i);

                if (cycle) {
                    return false;
                }
            }
        }
        return true;
    }

    void dfs(List<Integer>[] graph, int i) {
        visited[i] = true;
        set.add(i);

        for (Integer nei : graph[i]) {
            if (set.contains(nei)) {
                cycle = true;
            }

            if (!visited[nei]) {
                dfs(graph, nei);
            }
        }

        set.remove(i);
    }
}
