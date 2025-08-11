package org.example.auz.practice.graph;

import java.util.List;

/**
 * Weighted UndiGraph
 * <p>
 * implemented by Adjacency List
 */
public class WeightedUndiGraph_AdjacencyList {

    private DirectedWeightedGraph_AdjacencyList graph;

    public WeightedUndiGraph_AdjacencyList(int n) {
        graph = new DirectedWeightedGraph_AdjacencyList(n);
    }

    // add an edge from -> to, with weight, O(1)
    public void addEdge(int from, int to, int weight) {
        graph.addEdge(from, to, weight);
        graph.addEdge(to, from, weight);
    }

    // remove an edge from -> to, O(V)
    public void removeEdge(int from, int to) {
        graph.removeEdge(from, to);
        graph.removeEdge(to, from);
    }

    // find from is neighbour to, O(V)
    public boolean hasEdge(int from, int to) {
        return graph.hasEdge(from, to);
    }

    // find weight from -> to, O(V)
    public int weight(int from, int to) {
        return graph.weight(from, to);
    }

    // find v's all neighbours, O(1)
    public List<DirectedWeightedGraph_AdjacencyList.Edge> neighbors(int v) {
        return graph.neighbors(v);
    }

    public static void main(String[] args) {
        WeightedUndiGraph_AdjacencyList graph = new WeightedUndiGraph_AdjacencyList(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // true

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " <-> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 <-> 0, wight: 3
        // 2 <-> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
        System.out.println(graph.hasEdge(1, 0)); // false
    }
}
