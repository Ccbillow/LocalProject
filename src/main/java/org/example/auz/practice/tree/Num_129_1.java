package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
public class Num_129_1 {

    int res = 0;

    int num = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        num = num * 10 + root.val;

        if (root.left == null && root.right == null) {
            res = res + num;
        }

        traverse(root.left);
        traverse(root.right);

        num = (num - root.val) / 10;
    }
}
