package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 687. Longest Univalue Path
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class Num_687_1 {

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        traverse(root);
        return res;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }


        int left = traverse(root.left);
        int right = traverse(root.right);

        int leftPath = 0;
        int rightPath = 0;
        if (left != 0 && root.val == root.left.val) {
            leftPath = left + 1;
        }
        if (right != 0 && root.val == root.right.val) {
            rightPath = right + 1;
        }

        res = Math.max(res, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
