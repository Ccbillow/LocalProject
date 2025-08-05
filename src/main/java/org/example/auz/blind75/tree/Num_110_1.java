package org.example.auz.blind75.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * time: O(n ^ 2)
 * space: O(h)
 */
public class Num_110_1 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = high(root.left);
        int right = high(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int high(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(high(root.left), high(root.right)) + 1;
    }
}
