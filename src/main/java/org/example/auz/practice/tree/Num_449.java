package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 449. Serialize and Deserialize BST
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 */
public class Num_449 {

    String SEP = ",";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(SEP);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(SEP);
        LinkedList<Integer> deque = new LinkedList<>();
        for (String node : nodes) {
            deque.addLast(Integer.parseInt(node));
        }
        return build(deque, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode build(LinkedList<Integer> nodes, int min, int max) {
        if (nodes.isEmpty()) {
            return null;
        }

        if (nodes.peekFirst() > max || nodes.peekFirst() < min) {
            return null;
        }

        Integer rootVal = nodes.removeFirst();
        TreeNode root = new TreeNode(rootVal);

        root.left = build(nodes, min, rootVal);
        root.right = build(nodes, rootVal, max);

        return root;
    }
}
