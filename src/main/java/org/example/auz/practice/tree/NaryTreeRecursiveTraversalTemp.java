package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.Node;

/**
 * n-ary tree
 * dfs
 */
public class NaryTreeRecursiveTraversalTemp {

    public void traverse(Node root) {
        if (root == null) {
            return;
        }

        //pre
        System.out.println("visit: " + root.val);

        for (Node child : root.children) {
            traverse(child);
        }

        //post
    }
}
