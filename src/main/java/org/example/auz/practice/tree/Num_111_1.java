package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * dfs
 */
public class Num_111_1 {

    private int minDepth = Integer.MAX_VALUE;
    private int curDepth = 0;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        traverse(root);
        return minDepth;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        curDepth++;

        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, curDepth);
        }

        traverse(root.left);
        traverse(root.right);

        curDepth--;
    }
}
