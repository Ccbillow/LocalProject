package org.example.auz.blind75.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * time: O(n ^ 2)
 * space: O(h)
 */
public class Num_110_2 {

    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        high(root);
        return flag;
    }

    private int high(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = high(root.left);
        int right = high(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
