package org.example.auz.practice.graph;

import org.example.auz.blind75.tool.graph.Edge;
import org.example.auz.blind75.tool.graph.Graph;

public class FindBranch {

    void tarveseEdges(Graph graph, int s, boolean[][] visited) {
        if (s < 0 || s >= graph.size()) {
            return;
        }

        for (Edge edge : graph.neighbors(s)) {
            if (visited[s][edge.to]) {
                continue;
            }

            visited[s][edge.to] = true;
            System.out.println("visit edge: " + s + "->" + edge.to);
            tarveseEdges(graph, edge.to, visited);
        }
    }
}
