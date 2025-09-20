package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class Num_110_2 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> height = new HashMap<>();

        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }


            TreeNode cur = stack.peekLast();
            if (cur.right != null && cur.right != prev) {
                root = cur.right;
            } else {
                stack.removeLast();

                int left = cur.left == null ? 0 : height.get(cur.left);
                int right = cur.right == null ? 0 : height.get(cur.right);

                if (Math.abs(left - right) > 1) {
                    return false;
                }

                height.put(cur, Math.max(left, right) + 1);

                prev = cur;
            }
        }

        return true;
    }

}
