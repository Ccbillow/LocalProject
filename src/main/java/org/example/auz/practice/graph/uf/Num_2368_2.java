package org.example.auz.practice.graph.uf;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2368. reachable-nodes-with-restrictions
 *
 * https://leetcode.cn/problems/reachable-nodes-with-restrictions/description/
 */
public class Num_2368_2 {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            set.add(restricted[i]);
        }

        if (set.contains(0)) {
            return 0;
        }

        UF uf = new UF(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (set.contains(x) || set.contains(y)) {
                continue;
            }
            uf.union(x, y);
        }
        int res = 0;
        int root = uf.find(0);
        for (int i = 0; i < n; i++) {
            if (!set.contains(i) && uf.find(i) == root) {
                res++;
            }
        }
        return res;
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
