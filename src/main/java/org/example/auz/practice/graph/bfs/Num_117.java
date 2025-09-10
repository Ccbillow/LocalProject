package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Populating Next Right Pointers in Each Node II
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/?show=1
 */
public class Num_117 {

    class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Deque<Node> q = new ArrayDeque<>();
        q.addLast(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.removeFirst();

                if (i != size - 1) {
                    cur.next = q.peekFirst();
                } else {
                    cur.next = null;
                }

                if (cur.left != null) {
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    q.addLast(cur.right);
                }
            }
        }
        return root;
    }
}
