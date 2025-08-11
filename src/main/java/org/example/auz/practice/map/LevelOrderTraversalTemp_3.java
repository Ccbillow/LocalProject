package org.example.auz.practice.map;

import org.example.auz.blind75.tool.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Level Order Traversal (BFS)
 */
public class LevelOrderTraversalTemp_3 {

    class State {
        Node node;
        int depth;

        public State(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Deque<State> queue = new LinkedList<>();
        queue.addLast(new State(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State cur = queue.pollFirst();

                System.out.println("depth: " + cur.depth + ", val:" + cur.node.val);
                for (Node child : cur.node.children) {
                    queue.addLast(new State(child, cur.depth + 1));
                }
            }
        }
    }
}
