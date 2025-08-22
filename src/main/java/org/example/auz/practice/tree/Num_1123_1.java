package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1123. Lowest Common Ancestor of Deepest Leaves
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/
 */
public class Num_1123_1 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if (left == right) {
            return root;
        } else if (left > right) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
