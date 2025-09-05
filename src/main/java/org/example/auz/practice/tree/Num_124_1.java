package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 124. binary-tree-maximum-path-sum
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 */
public class Num_124_1 {

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

        res = Math.max(res, left + right + root.val);

        int cur = root.val + Math.max(left, right);
        if (cur < 0) {
            return 0;
        }
        return cur;
    }

    public static void main(String[] args) {
        Num_124_1 test = new Num_124_1();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        test.maxPathSum(node1);
    }
}
