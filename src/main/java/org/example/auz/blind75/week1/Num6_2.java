package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.TreeNode;

/**
 * Invert Binary Tree
 *
 * desc: https://leetcode.com/problems/invert-binary-tree/description/
 */
public class Num6_2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
