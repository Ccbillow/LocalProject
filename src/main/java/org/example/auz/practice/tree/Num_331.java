package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.LinkedList;

/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 */
public class Num_331 {

    String SEP = ",";
    String NULL = "#";

    public boolean isValidSerialization(String preorder) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : preorder.split(SEP)) {
            nodes.addLast(s);
        }
        return _deserilization(nodes) && nodes.isEmpty();
    }

    private boolean _deserilization(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return false;
        }
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return true;
        }
        boolean left = _deserilization(nodes);
        boolean right = _deserilization(nodes);
        return left && right;
    }
}
