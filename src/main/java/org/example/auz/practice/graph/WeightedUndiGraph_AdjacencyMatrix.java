package org.example.auz.practice.graph;

import java.util.List;

/**
 * Weighted UndiGraph
 * <p>
 * implemented by Adjacency Metrix
 */
public class WeightedUndiGraph_AdjacencyMatrix {

    private DirectedWeightedGraph_AdjacencyMatrix matrix;

    public WeightedUndiGraph_AdjacencyMatrix(int n) {
        matrix = new DirectedWeightedGraph_AdjacencyMatrix(n);
    }

    // add an edge from -> to, with weight, O(1)
    public void addEdge(int from, int to, int weight) {
        matrix.addEdge(from, to, 1);
    }

    // remove an edge from -> to, O(1)
    public void removeEdge(int from, int to) {
        matrix.removeEdge(from, to);
    }

    // find from is neighbour to, O(1)
    public boolean hasEdge(int from, int to) {
        return matrix.hasEdge(from, to);
    }

    // find weight from -> to, O(1)
    public int weight(int from, int to) {
        return matrix.weight(from, to);
    }

    // find v's all neighbours, O(v)
    public List<DirectedWeightedGraph_AdjacencyMatrix.Edge> neighbors(int v) {
        return matrix.neighbors(v);
    }
}
