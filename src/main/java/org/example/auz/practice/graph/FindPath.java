package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * find **all** path
 *
 * src -> dest
 *
 * find all nodes, src -> dest
 */
public class FindPath {

    public List<Integer> findPath(Graph graph, int src, int dest) {
        List<Integer> path = new ArrayList<>();
        boolean[] onPath = new boolean[graph.size()];
        traverse(graph, src, dest, path, onPath);
        return path;
    }

    private boolean traverse(Graph graph, int src, int dest, List<Integer> path, boolean[] onPath) {
        if (src < 0 || src >= graph.size()) {
            return false;
        }

        if (onPath[src]) {
            return false;
        }

        if (src == dest) {
            path.add(src);
            return true;
        }

        onPath[src] = true;
        path.add(src);

        for (Adjacency_Weight.Edge neighbor : graph.neighbors(src)) {
            if (traverse(graph, neighbor.to, dest, path, onPath)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        onPath[src] = false;
        return false;
    }
}
