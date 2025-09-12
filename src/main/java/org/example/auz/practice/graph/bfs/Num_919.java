package org.example.auz.practice.graph.bfs;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 919. Complete Binary Tree Inserter
 * https://leetcode.com/problems/complete-binary-tree-inserter/description/
 */
public class Num_919 {

    TreeNode root;
    Deque<TreeNode> q = new ArrayDeque<>();

    public Num_919(TreeNode root) {
        this.root = root;

        Deque<TreeNode> temp = new ArrayDeque<>();
        temp.addLast(root);
        while (!temp.isEmpty()) {
            TreeNode cur = temp.removeFirst();
            if (cur.left != null) {
                temp.addLast(cur.left);
            }
            if (cur.right != null) {
                temp.addLast(cur.right);
            }
            if (cur.left == null || cur.right == null) {
                q.addLast(cur);
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        q.addLast(node);

        TreeNode cur = q.peekFirst();
        if (cur.left == null) {
            cur.left = node;
        } else if (cur.right == null) {
            cur.right = node;
            q.removeFirst();
        }
        return cur.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
