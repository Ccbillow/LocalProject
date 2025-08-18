package org.example.auz.practice.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 116. Populating Next Right Pointers in Each Node
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 */
public class Num_116_1 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.pollFirst();
                if (i != size - 1) {
                    cur.next = queue.peekFirst();
                }

                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
