package org.example.auz.blind75.map;

import org.example.auz.blind75.tool.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class Num_589 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        traverse(root);
        return res;
    }

    private void traverse(Node root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (Node child : root.children) {
            traverse(child);
        }
    }
}
