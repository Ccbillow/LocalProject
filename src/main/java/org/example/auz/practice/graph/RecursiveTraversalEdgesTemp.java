package org.example.auz.practice.graph;

import org.example.auz.blind75.tool.Vertex;

/**
 * graph
 *
 *  traverse all branches
 *
 * dfs
 */
public class RecursiveTraversalEdgesTemp {

    // traverse all edges
    // boolean[][] visited to save visited branches, visited[u][v] means u->v has been visited
    public void traverseEdges(Vertex s, boolean[][] visited) {
        if (s == null) {
            return;
        }

        for (Vertex neighbour : s.neighbours) {
            // visited[u][v] means u->v has been visited
            if (visited[s.id][neighbour.id]) {
                continue;
            }

            // marks visit edge, visited[u][v]
            visited[s.id][neighbour.id] = true;
            System.out.println("visit edge: " + s.id + " -> " + neighbour.id);
            traverseEdges(neighbour, visited);
        }

        //post
    }

    public void traverseEdges(Graph graph, int s, boolean[][] visited) {
        if (s < 0 || s >= graph.size()) {
            return;
        }

        for (Adjacency_Weight.Edge edge : graph.neighbors(s)) {
            if (visited[s][edge.to]) {
                continue;
            }

            visited[s][edge.to] = true;
            System.out.println("visit edge: " + s + " -> " + edge.to);
            traverseEdges(graph, edge.to, visited);
        }

        //post
    }

}
