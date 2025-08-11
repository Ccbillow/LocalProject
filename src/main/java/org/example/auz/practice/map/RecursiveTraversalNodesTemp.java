package org.example.auz.practice.map;

import org.example.auz.blind75.tool.Node;

/**
 * Recursive Traversal (DFS)
 *
 * all nodes
 */
public class RecursiveTraversalNodesTemp {

    public void traversal(Node root) {
        if (root == null) {
            return;
        }

        //pre order
        System.out.println("visit " + root.val);

        for (Node child : root.children) {
            traversal(child);
        }

        //post order
    }

}
