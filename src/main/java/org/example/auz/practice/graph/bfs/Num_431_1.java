package org.example.auz.practice.graph.bfs;

import org.example.auz.blind75.tool.Node;
import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;

/**
 * Encode N-ary Tree to Binary Tree
 */
public class Num_431_1 {

    TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }

        TreeNode treeRoot = new TreeNode(root.val);
        if (!root.children.isEmpty()) {
            treeRoot.left = encode(root.children.get(0));
        }
        TreeNode cur = treeRoot.left;
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return treeRoot;
    }



    Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }

        Node node = new Node(root.val, new ArrayList<>());
        TreeNode cur = root.left;
        while (cur != null) {
            node.children.add(decode(cur));
            cur = cur.right;
        }
        return node;
    }
}
