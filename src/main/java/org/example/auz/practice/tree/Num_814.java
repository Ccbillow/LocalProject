package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 814. Binary Tree Pruning
 *
 * https://leetcode.com/problems/binary-tree-pruning/description/
 */
public class Num_814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
