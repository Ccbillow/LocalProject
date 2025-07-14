package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.TreeNode;

/**
 * Balanced Binary Tree
 *
 * desc: https://leetcode.com/problems/balanced-binary-tree/description/
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(log n) - O(n)
 */
public class Num11_1 {

    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        heigh(root);
        return balanced;
    }

    private int heigh(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = heigh(root.left);
        int right = heigh(root.right);
        if (Math.abs(left - right) > 1) {
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
