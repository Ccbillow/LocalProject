package org.example.auz.practice.graph;

import org.example.auz.blind75.tool.graph.UnionFind;

import java.util.Arrays;

/**
 * 1361. Validate Binary Tree Nodes
 * https://leetcode.com/problems/validate-binary-tree-nodes/description/?show=1
 */
public class Num_1361 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UF uf = new UF(n);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            int child = leftChild[i];
            if (child != -1) {
                if (parent[child] != -1) {
                    return false;
                }

                parent[child] = i;

                if (uf.connected(i, child)) {
                    return false;
                }

                uf.union(i, child);
            }
        }
        for (int i = 0; i < n; i++) {
            int child = rightChild[i];
            if (child != -1) {
                if (parent[child] != -1) {
                    return false;
                }

                parent[child] = i;

                if (uf.connected(i, child)) {
                    return false;
                }

                uf.union(i, child);
            }
        }

        int rootCount = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                rootCount++;
            }
        }
        if (rootCount != 1) {
            return false;
        }

        return uf.count == 1;
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return parent[x] = find(parent[x]);
            }
        }

        void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                parent[rootx] = rooty;
                count--;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
