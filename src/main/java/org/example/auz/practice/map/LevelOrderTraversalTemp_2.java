package org.example.auz.practice.map;

import org.example.auz.blind75.tool.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Level Order Traversal (BFS)
 */
public class LevelOrderTraversalTemp_2 {

    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.addLast(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();

                System.out.println("depth : " + depth + ", val = " + cur.val);
                for (Node child : cur.children) {
                    queue.addLast(child);
                }
            }
            depth++;
        }
    }
}
