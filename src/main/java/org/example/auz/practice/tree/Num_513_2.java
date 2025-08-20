package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 513. Find Bottom Left Tree Value
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 */
public class Num_513_2 {


    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.removeFirst();
                if (i == 0) {
                    res = cur.val;
                }

                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
        }
        return res;
    }


}
