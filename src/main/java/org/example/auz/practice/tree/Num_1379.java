package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/
 */
public class Num_1379 {


    TreeNode res;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        traverse(original, cloned, target);
        return res;
    }

    private void traverse(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return;
        }

        if (res != null) {
            return;
        }

        if (original == target) {
            res = cloned;
            return;
        }

        traverse(original.left, cloned.left, target);
        traverse(original.right, cloned.right, target);
    }
}
