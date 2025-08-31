package org.example.auz.practice.graph;

/**
 * 990. Satisfiability of Equality Equations
 * https://leetcode.com/problems/satisfiability-of-equality-equations/description/
 */
public class Num_990 {

    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.connected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }

        return true;
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

        int count() {
            return count;
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return parent[x] = find(parent[x]);
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootY != rootX) {
                parent[rootX] = rootY;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
