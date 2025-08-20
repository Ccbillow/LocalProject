package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 513. Find Bottom Left Tree Value
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 */
public class Num_513_1 {

    int res = 0;
    int depth = 0;
    int maxDepth = 0;

    public int findBottomLeftValue(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }

        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
