package org.example.auz.practice.graph;

import org.example.auz.blind75.tool.graph.UnionFind;

/**
 * 1361. Validate Binary Tree Nodes
 * https://leetcode.com/problems/validate-binary-tree-nodes/description/?show=1
 */
public class Num_1361 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                int child = leftChild[i];
                indegree[child]++;
                if (indegree[child] > 1) {
                    return false;
                }
                if (uf.connected(i, child)) {
                    return false;
                }
                uf.union(i, child);
            }
            if (rightChild[i] != -1) {
                int child = rightChild[i];
                indegree[child]++;
                if (indegree[child] > 1) {
                    return false;
                }
                if (uf.connected(i, child)) {
                    return false;
                }
                uf.union(i, child);
            }
        }

        int root = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                root++;
            }
        }
        if (root != 1) {
            return false;
        }

        return uf.count() == 1;
    }
}
