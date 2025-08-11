package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Traversal (BFS)
 */
public class LevelOrderTraversalTemp_3 {
    class State {
        TreeNode node;
        int depth;

        public State(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(root, 1));
        
        while (!queue.isEmpty()) {
            State cur = queue.poll();

            System.out.println("depth = " + cur.depth + ", val = " + cur.node.val);

            if (cur.node.left != null) {
                queue.add(new State(cur.node.left, cur.depth + 1));
            }
            if (cur.node.right != null) {
                queue.add(new State(cur.node.right, cur.depth + 1));
            }
        }
    }
}
