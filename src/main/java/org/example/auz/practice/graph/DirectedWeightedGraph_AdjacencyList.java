package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Directed Weighted Graph
 * <p>
 * implemented by Adjacency List
 */
public class DirectedWeightedGraph_AdjacencyList {

    // neighbour node with weight
    public class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // adjacency list, graph[v] save v's neighbours with weight
    private List<Edge>[] graph;

    public DirectedWeightedGraph_AdjacencyList(int n) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            // future optimize: graph = Map<Integer, List<Edge>>
            graph[i] = new ArrayList<>();
        }
    }

    // add an edge from -> to, with weight, O(1)
    public void addEdge(int from, int to, int weight) {
        graph[from].add(new Edge(to, weight));
    }

    // remove an edge from -> to, O(V)
    public void removeEdge(int from, int to) {
        for (int i = 0; i < graph[from].size(); i++) {
            if (graph[from].get(i).to == to) {
                graph[from].remove(i);
                break;
            }
        }
    }

    // find from is neighbour to, O(V)
    public boolean hasEdge(int from, int to) {
        for (Edge edge : graph[from]) {
            if (edge.to == to) {
                return true;
            }
        }
        return false;
    }

    // find weight from -> to, O(V)
    public int weight(int from, int to) {
        for (Edge edge : graph[from]) {
            if (edge.to == to) {
                return edge.weight;
            }
        }
        throw new IllegalArgumentException("No such edge");
    }

    // find v's all neighbours, O(1)
    public List<Edge> neighbors(int v) {
        return graph[v];
    }

    public static void main(String[] args) {
        DirectedWeightedGraph_AdjacencyList graph = new DirectedWeightedGraph_AdjacencyList(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // false

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 -> 0, wight: 3
        // 2 -> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
    }
}
