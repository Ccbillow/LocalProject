package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N-ary Tree Level Order Traversal
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 */
public class Num_429 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new LinkedList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.removeFirst();

                level.add(cur.val);
                for (Node child : cur.children) {
                    queue.addLast(child);
                }
            }
            res.add(level);
        }
        return res;
    }
}
