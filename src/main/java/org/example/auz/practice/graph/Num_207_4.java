package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Num_207_4 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] indegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            int from = p[1];
            int to = p[0];
            graph[from].add(to);
            indegrees[to]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.addLast(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            count++;
            for (int nei : graph[cur]) {
                indegrees[nei]--;
                if (indegrees[nei] == 0) {
                    q.addLast(nei);
                }
            }
        }
        return count == numCourses;
    }
}
