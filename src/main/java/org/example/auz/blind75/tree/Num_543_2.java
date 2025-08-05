package org.example.auz.blind75.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class Num_543_2 {

    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        high(root);
        return max;
    }

    private int high(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = high(root.left);
        int right = high(root.right);

        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}
