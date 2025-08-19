package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
public class Num_129 {

    int count = 0;
    int res = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            count = count * 10 + root.val;
            res = res + count;
            count = (count - root.val) / 10;
        }

        count = count * 10 + root.val;

        traverse(root.left);
        traverse(root.right);

        count = (count - root.val) / 10;
    }
}
