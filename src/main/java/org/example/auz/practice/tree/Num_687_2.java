package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 687. Longest Univalue Path
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class Num_687_2 {

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;

        traverse(root, root.val);
        return max;
    }

    int traverse(TreeNode root, int parent) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left, root.val);
        int right = traverse(root.right, root.val);

        max = Math.max(max, left + right);

        if (root.val == parent) {
            return 1 + Math.max(left, right);
        }

        return 0;
    }
}
