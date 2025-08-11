package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * Recursive Traversal (DFS)
 */
public class RecursiveTraversalTemp {

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.left);
        traversal(root.right);
    }
}
