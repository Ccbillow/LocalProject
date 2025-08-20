package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */
public class Num_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();

                if (flag) {
                    level.addLast(cur.val);
                } else {
                    level.addFirst(cur.val);
                }

                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
            flag = !flag;
            res.add(level);
        }
        return res;
    }
}
