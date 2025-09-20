package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 124. binary-tree-maximum-path-sum
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 */
public class Num_124_3 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return res;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(traverse(root.left), 0);
        int right = Math.max(traverse(root.right), 0);

        res = Math.max(res, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
