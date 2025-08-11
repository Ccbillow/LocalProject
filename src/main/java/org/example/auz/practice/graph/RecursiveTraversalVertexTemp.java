package org.example.auz.practice.graph;

import org.example.auz.blind75.tool.Vertex;

/**
 * graph
 *
 * traverse all nodes
 *
 * dfs
 */
public class RecursiveTraversalVertexTemp {

    // traverse all nodes
    public void traversrVertex(Vertex s, boolean[] visited) {
        if (s == null) {
            return;
        }

        if (visited[s.id]) {
            // avoid infinite loop
            return;
        }

        //pre
        visited[s.id] = true;
        System.out.println("visit vertex:" + s.id);

        for (Vertex neighbour : s.neighbours) {
            traversrVertex(neighbour, visited);
        }

        //post
    }

    public void traverseVertex(Graph graph, int s, boolean[] visited) {
        if (s < 0 || s >= graph.size()) {
            return;
        }

        if (visited[s]) {
            return;
        }

        //pre
        visited[s] = true;
        System.out.println("visit vertex:" + s);

        for (Adjacency_Weight.Edge neighbor : graph.neighbors(s)) {
            traverseVertex(graph, neighbor.to, visited);
        }

        //post
    }

}
