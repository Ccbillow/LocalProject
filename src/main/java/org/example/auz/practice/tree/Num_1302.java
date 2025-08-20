package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1302. Deepest Leaves Sum
 *
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 */
public class Num_1302 {

    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<List<Integer>> list = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.removeFirst();

                level.add(cur.val);
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
            list.addFirst(level);
        }
        for (Integer i : list.removeFirst()) {
            res = res + i;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node3.left = node6;

        node2.right = node5;
        node5.right = node7;

        deepestLeavesSum(root);
    }
}
