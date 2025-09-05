package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 124. binary-tree-maximum-path-sum
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 */
public class Num_124_2 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
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

        int cant = Math.max(Math.max(left, right), left + right + root.val);
        int can = Math.max(Math.max(root.val + left, root.val + right), root.val);

        res = Math.max(res, Math.max(cant, can));
        return can;
    }


}
