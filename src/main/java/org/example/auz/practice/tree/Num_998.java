package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 998. Maximum Binary Tree II
 * https://leetcode.com/problems/maximum-binary-tree-ii/description/
 */
public class Num_998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.right = insertIntoMaxTree(root.right, val);
        } else {
            TreeNode tmp = root;
            root = new TreeNode(val);
            root.left = tmp;
        }
        return root;
    }
}
