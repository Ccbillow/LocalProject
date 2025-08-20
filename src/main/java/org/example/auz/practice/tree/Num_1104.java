package org.example.auz.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1104. Path In Zigzag Labelled Binary Tree
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/description/
 */
public class Num_1104 {

    /*
                      1
                3           2
            4     5       6     7
          15 14  13 12  11 10  9  8
     */
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        while (label >= 1) {
            res.add(label);
            // 6
            label = label / 2;

            int depth = log(label);
            // 4, 7
            int[] range = getLevelRange(depth);
            // 5 = 7 - (6 - 4)
            label = range[1] - (label - range[0]);
        }
        Collections.reverse(res);
        return res;
    }

    private int[] getLevelRange(int n) {
        int p = (int) Math.pow(2, n);
        return new int[]{p, 2 * p - 1};
    }

    int log(int x) {
        return  (int)(Math.log(x) / Math.log(2));
    }
}
