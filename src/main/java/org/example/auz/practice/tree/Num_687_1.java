package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 687. Longest Univalue Path
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class Num_687_1 {

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        traverse(root);
        return max;
    }

    int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        int leftPath = 0;
        int rightPath = 0;
        if (root.left != null && root.left.val == root.val) {
            leftPath = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightPath = right + 1;
        }

        max = Math.max(max, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
