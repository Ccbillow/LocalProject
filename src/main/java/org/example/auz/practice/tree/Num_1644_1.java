package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1644. Lowest Common Ancestor of a Binary Tree II
 */
public class Num_1644_1 {

    boolean foundp = false;
    boolean foundq = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cla = dfs(root, p, q);
        if (foundp && foundq) {
            return cla;
        }
        return null;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        if (root == p) {
            foundp = true;
            return root;
        }
        if (root == q) {
            foundq = true;
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
