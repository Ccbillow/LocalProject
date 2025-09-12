package org.example.auz.practice.graph.bfs;

import org.example.auz.blind75.tool.Node;
import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Encode N-ary Tree to Binary Tree
 */
public class Num_431_2 {

    TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }

        TreeNode treeRoot = new TreeNode(root.val);
        if (!root.children.isEmpty()) {
            Deque<Node> q = new ArrayDeque<>(root.children);
            TreeNode cur = null;

            while (!q.isEmpty()) {
                Node child = q.removeFirst();
                TreeNode bChild = new TreeNode(child.val);

                if (cur == null) {
                    treeRoot.left = bChild;
                } else {
                    cur.right = bChild;
                }

                cur = bChild;
            }
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
