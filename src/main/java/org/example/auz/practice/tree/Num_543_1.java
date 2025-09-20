package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class Num_543_1 {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return res;
    }

    int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;
    }
}
