package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Directed Weighted Graph
 * <p>
 * implemented by Adjacency Metrix
 */
public class DirectedWeightedGraph_AdjacencyMatrix {

    // neighbour node with weight
    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // adjacency matrix, matrix[from][to] save from -> to weight
    // 0 means no neighbour
    private int[][] matrix;

    public DirectedWeightedGraph_AdjacencyMatrix(int n) {
        matrix = new int[n][n];
    }

    // add an edge from -> to, with weight, O(1)
    public void addEdge(int from, int to, int weight) {
        matrix[from][to] = weight;
    }

    // remove an edge from -> to, O(1)
    public void removeEdge(int from, int to) {
        matrix[from][to] = 0;
    }

    // find from is neighbour to, O(1)
    public boolean hasEdge(int from, int to) {
        return matrix[from][to] != 0;
    }

    // find weight from -> to, O(1)
    public int weight(int from, int to) {
        return matrix[from][to];
    }

    // find v's all neighbours, O(v)
    public List<Edge> neighbors(int v) {
        List<Edge> res = new ArrayList<>();
        for (int i = 0; i < matrix[v].length; i++) {
            if (matrix[v][i] != 0) {
                res.add(new Edge(i, matrix[v][i]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DirectedWeightedGraph_AdjacencyMatrix graph = new DirectedWeightedGraph_AdjacencyMatrix(3);
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
