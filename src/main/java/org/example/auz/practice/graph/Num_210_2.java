package org.example.auz.practice.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class Num_210_2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = build(numCourses, prerequisites);

        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            indegree[to]++;
        }

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.addLast(i);
            }
        }

        int res[] = new int[numCourses];
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            res[count] = cur;
            count++;
            for (int neighbor : graph[cur]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.addLast(neighbor);
                }
            }
        }

        if (count != numCourses) {
            return new int[]{};
        }
        return res;
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
