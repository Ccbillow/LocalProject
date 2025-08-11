package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 *
 * bfs
 */
public class Num_797_2 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<List<Integer>> deque = new ArrayDeque<>();
        deque.add(List.of(0));

        int dest = graph.length - 1;

        while (!deque.isEmpty()) {
            List<Integer> path = deque.pollFirst();
            int last = path.get(path.size() - 1);
            if (last == dest) {
                res.add(new ArrayList<>(path));
                continue;
            }

            for (int neighbour : graph[last]) {
                ArrayList<Integer> newPath = new ArrayList<>(path);
                newPath.add(neighbour);
                deque.add(newPath);
            }
        }

        return res;
    }


}
