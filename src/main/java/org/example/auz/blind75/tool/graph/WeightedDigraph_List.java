package org.example.auz.blind75.tool.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedDigraph_List implements Graph{

    private List<Edge>[] graph;

    public WeightedDigraph_List(int n) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, int weight) {
        graph[from].add(new Edge(to, weight));
    }

    public void removeEdge(int from, int to) {
        for (int i = 0; i < graph[from].size(); i++) {
            if (graph[from].get(i).to == to) {
                graph[from].remove(i);
                break;
            }
        }
    }

    public boolean hasEdge(int from, int to) {
        for (Edge edge : graph[from]) {
            if (edge.to == to) {
                return true;
            }
        }
        return false;
    }

    public int weight(int from, int to) {
        for (Edge edge : graph[from]) {
            if (edge.to == to) {
                return edge.weight;
            }
        }
        throw new IllegalArgumentException("No such edge");
    }

    public List<Edge> neighbors(int v) {
        return graph[v];
    }

    @Override
    public int size() {
        return graph.length;
    }


}
