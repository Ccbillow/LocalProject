package org.example.auz.blind75.tool.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedDigraph_Matrix implements Graph{

    private int[][] matrix;

    public WeightedDigraph_Matrix(int n) {
        matrix = new int[n][n];
    }

    public void addEdge(int from, int to, int weight) {
        matrix[from][to] = weight;
    }

    public void removeEdge(int from, int to) {
        matrix[from][to] = 0;
    }

    public boolean hasEdge(int from, int to) {
        return matrix[from][to] != 0;
    }

    public int weight(int from, int to) {
        return matrix[from][to];
    }

    public List<Edge> neighbors(int v) {
        List<Edge> res = new ArrayList<>();
        for (int i = 0; i < matrix[v].length; i++) {
            if (matrix[v][i] != 0) {
                res.add(new Edge(i, matrix[v][i]));
            }
        }
        return res;
    }

    @Override
    public int size() {
        return matrix.length;
    }


}
