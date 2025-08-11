package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 *
 * dfs
 */
public class Num_797_1 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0);
        return res;
    }

    private void traverse(int[][] graph, int i) {
        if (i < 0 || i >= graph.length) {
            return;
        }

        path.add(i);

        // cur node is dest node
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for (int neighbour : graph[i]) {
            traverse(graph, neighbour);
        }

        path.remove(path.size() - 1);
    }
}
