package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.LinkedList;

/**
 * 897. Increasing Order Search Tree
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 */
public class Num_897_1 {

    LinkedList<Integer> list = new LinkedList<>();
    public TreeNode increasingBST(TreeNode root) {
        traverse(root);

        TreeNode res = new TreeNode(list.removeFirst());
        TreeNode cur = res;
        while (!list.isEmpty()) {
            cur.left = null;
            cur.right = new TreeNode(list.removeFirst());
            cur = cur.right;
        }
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        list.addLast(root.val);
        traverse(root.right);
    }
}
