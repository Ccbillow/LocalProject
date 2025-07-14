package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.TreeNode;

/**
 * Invert Binary Tree
 *
 * desc: https://leetcode.com/problems/invert-binary-tree/description/
 */
public class Num6_1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
