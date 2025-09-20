package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 250: Count Univalue Subtrees
 */
public class Num_250 {

    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        if (!left || !right) {
            return false;
        }

        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        res++;
        return true;
    }
}
