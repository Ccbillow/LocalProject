package org.example.auz.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 * time: O (n log n * k)
 * k is length of String, about log n
 *
 * space: O(n)
 */
public class Num_386_2 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }

        res.sort((a, b) -> {
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            return s1.compareTo(s2);
        });
        return res;
    }


}
