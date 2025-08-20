package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
 */
public class Num_1315 {

    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    sum = sum + root.left.left.val;
                }
                if (root.left.right != null) {
                    sum = sum + root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    sum = sum + root.right.left.val;
                }
                if (root.right.right != null) {
                    sum = sum + root.right.right.val;
                }
            }
        }

        traverse(root.left);
        traverse(root.right);
    }
}
