package org.example.auz.practice.map;

import org.example.auz.blind75.tool.Node;

/**
 * Recursive Traversal (DFS)
 *
 * all nodes
 */
public class RecursiveTraversalBranchesTemp {

    public void traversal(Node root) {
        if (root == null) {
            return;
        }

        //pre order

        for (Node child : root.children) {
            System.out.println("visit branch: " + root.val + "->" + child.val);
            traversal(child);
        }

        //post order
    }

}
