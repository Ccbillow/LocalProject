package org.example.auz.practice.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Lowest Common Ancestor of a Binary Tree III
 *
 */
public class Num_1650_1 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = p.parent;
        }

        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }
}
