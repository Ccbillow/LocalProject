package org.example.auz.practice.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 947. Most Stones Removed with Same Row or Column
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/?show=1
 */
public class Num_947_1 {

    public int removeStones(int[][] stones) {
        UF uf = new UF();
        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10000);
        }
        return stones.length - uf.count;
    }

    class UF {
        Map<Integer, Integer> parent = new HashMap<>();
        int count = 0;

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }

            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent.put(rootX, rootY);
                count--;
            }
        }
    }
}
