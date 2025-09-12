package org.example.auz.practice.graph.uf;

import java.util.Arrays;

/**
 * 924. minimize-malware-spread
 * https://leetcode.cn/problems/minimize-malware-spread/description/?show=1
 */
public class Num_924_3 {


    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        int[] infectCnt = new int[n];
        for (int i : infectCnt) {
            infectCnt[uf.find(i)]++;
        }

        Arrays.sort(initial);
        int res = initial[0];
        int max = -1;

        for (int i : initial) {
            int root = uf.find(i);

            if (infectCnt[root] == 1) {
                int size = uf.size(root);
                if (size > max) {
                    max = size;
                    res = i;
                }
            }
        }
        return res;
    }

    class UF {
        int count;
        int[] parent;
        int[] size;

        public UF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int size(int x) {
            return size[x];
        }

        int find(int x){
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
                if (size[rootx] >= size[rooty]) {
                    parent[rooty] = rootx;
                    size[rootx] = size[rooty] + size[rootx];
                } else {
                    parent[rootx] = rooty;
                    size[rooty] = size[rootx] + size[rooty];
                }
                count--;
            }
        }
    }

}
