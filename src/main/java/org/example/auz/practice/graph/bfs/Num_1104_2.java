package org.example.auz.practice.graph.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1104. path-in-zigzag-labelled-binary-tree
 * https://leetcode.cn/problems/path-in-zigzag-labelled-binary-tree/description/
 */
public class Num_1104_2 {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        res.add(label);

        while (label > 1) {
            int level = (int) (Math.log(label) / Math.log(2));

            int levelMax = (int) Math.pow(2, level) - 1;
            int levelMin = (int) Math.pow(2, level - 1);

            // parent = previous layer (maximum + minimum) - current value / 2
            label = levelMax + levelMin - label / 2;

            res.add(label);
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Num_1104_2 test = new Num_1104_2();
        test.pathInZigZagTree(14);
    }
}
