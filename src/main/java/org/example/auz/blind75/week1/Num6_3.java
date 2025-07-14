package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.TreeNode;

import java.util.Stack;

/**
 * Invert Binary Tree
 *
 * desc: https://leetcode.com/problems/invert-binary-tree/description/
 */
public class Num6_3 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            TreeNode tmp = current.left;
            current.left = current.right;
            current.right = tmp;

            if (current.left != null) {
                stack.add(current.left);
            }

            if (current.right != null) {
                stack.add(current.right);
            }
        }

        return root;
    }
}
