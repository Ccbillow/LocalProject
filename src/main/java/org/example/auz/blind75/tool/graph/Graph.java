package org.example.auz.blind75.tool.graph;

import java.util.List;

public interface Graph {

    void addEdge(int from, int to, int weight);

    void removeEdge(int from, int to);

    boolean hasEdge(int from, int to);

    int weight(int from, int to);

    List<Edge> neighbors(int v);

    // 返回节点总数
    int size();
}
