package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1609. Even Odd Tree
 * https://leetcode.com/problems/even-odd-tree/description/
 */
public class Num_1609 {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean even = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int pre = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.removeFirst();

                if (even) {
                    if (cur.val <= pre || cur.val % 2 != 1) return false;
                } else {
                    if (cur.val >= pre || cur.val % 2 != 0) return false;
                }

                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
            even = !even;
        }

        return true;
    }
}
