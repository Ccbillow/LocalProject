package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class Num_110_1 {

    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return res;
    }

    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if (Math.abs(left - right) > 1) {
            res = false;
        }

        return Math.max(left, right) + 1;
    }
}
