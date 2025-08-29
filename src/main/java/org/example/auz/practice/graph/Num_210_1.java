package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class Num_210_1 {


    boolean hasCycle = false;
    boolean[] visited;
    boolean[] onPath;

    List<Integer> postorder = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = build(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        if (hasCycle) {
            return new int[]{};
        }

        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (onPath[i]) {
            hasCycle = true;
        }

        if (visited[i] || hasCycle) {
            return;
        }

        onPath[i] = true;
        visited[i] = true;
        for (int t : graph[i]) {
            traverse(graph, t);
        }
        postorder.add(i);
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
