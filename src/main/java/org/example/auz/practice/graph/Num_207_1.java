package org.example.auz.practice.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/description/
 */
public class Num_207_1 {

    boolean[] onPath;

    boolean[] visited;
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = build(numCourses, prerequisites);

        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (hasCycle) {
            return;
        }

        if (onPath[i]) {
            hasCycle = true;
            return;
        }

        if (visited[i]) {
            return;
        }

        onPath[i] = true;
        visited[i] = true;

        for (int t : graph[i]) {
            traverse(graph, t);
        }

        onPath[i] = false;
    }

    private List<Integer>[] build(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
