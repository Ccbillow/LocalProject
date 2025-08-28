package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 */
public class Num_173 {

    private Deque<TreeNode> stack = new ArrayDeque<>();

    void push(TreeNode node) {
        while (node != null) {
            stack.addLast(node);
            node = node.left;
        }
    }
    public Num_173(TreeNode root) {
        push(root);
    }

    public int next() {
        TreeNode cur = stack.removeLast();
        push(cur.right);
        return cur.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
