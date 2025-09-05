package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class Num_543_2 {


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        int res = left + right;
        return Math.max(res,
                Math.max(diameterOfBinaryTree(root.left),
                        diameterOfBinaryTree(root.right)));
    }

    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        return 1 + Math.max(left, right);
    }
}
