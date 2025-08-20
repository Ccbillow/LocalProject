package org.example.auz.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_386_1 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            traverse(i, n);
        }
        return res;
    }

    private void traverse(int root, int n) {
        if (root > n) {
            return;
        }

        res.add(root);
        for (int child = root * 10; child < root * 10 + 10; child++) {
            traverse(child, n);
        }
    }
}
