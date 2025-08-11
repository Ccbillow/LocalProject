package org.example.auz.blind75.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */
public class Num_297_1 {
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        seHelper(root, builder);
        return builder.toString();
    }

    private void seHelper(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("null,");
            return;
        }
        builder.append(root.val).append(",");
        seHelper(root.left, builder);
        seHelper(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deHelper(nodes);
    }

    private TreeNode deHelper(Deque<String> nodes) {
        String val = nodes.pollFirst();
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deHelper(nodes);
        node.right = deHelper(nodes);
        return node;
    }
}
