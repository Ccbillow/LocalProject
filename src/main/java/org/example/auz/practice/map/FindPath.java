package org.example.auz.practice.map;

import org.example.auz.blind75.tool.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * find path
 *
 * root -> target
 *
 * find all nodes, root -> target
 */
public class FindPath {


    public List<Integer> findPath(Node root, Node target) {
        List<Integer> path = new ArrayList<>();
        traverse(root, target, path);
        return path;
    }

    public boolean traverse(Node root, Node target, List<Integer> path) {
        if (root == null) {
            return false;
        }

        if (root.val == target.val) {
            // find target, return the path
            path.add(root.val);
            return true;
        }

        path.add(root.val);

        for (Node child : root.children) {
            if (traverse(child, target, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}
