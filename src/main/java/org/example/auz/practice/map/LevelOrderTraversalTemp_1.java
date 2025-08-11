package org.example.auz.practice.map;

import org.example.auz.blind75.tool.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Level Order Traversal (BFS)
 */
public class LevelOrderTraversalTemp_1 {

    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node cur = queue.pollFirst();

            for (Node child : cur.children) {
                queue.addLast(child);
            }
        }
    }
}
