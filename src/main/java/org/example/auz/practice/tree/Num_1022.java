package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/
 */
public class Num_1022 {

    int path = 0;
    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res = res + path * 2 + root.val;
            return;
        }

        path = path * 2 + root.val;
        traverse(root.left);
        traverse(root.right);
        path = path / 2;
    }


}
