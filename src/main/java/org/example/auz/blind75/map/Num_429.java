package org.example.auz.blind75.map;

import org.example.auz.blind75.tool.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N-ary Tree Level Order Traversal
 */
public class Num_429 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.removeFirst();

                level.add(cur.val);

                for (Node child : cur.children) {
                    q.addLast(child);
                }
            }
            res.add(level);
        }
        return res;
    }
}
