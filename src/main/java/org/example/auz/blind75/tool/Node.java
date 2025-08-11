package org.example.auz.blind75.tool;

import java.util.List;

public class Node {

    public int val;

    public List<Node> children;

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public Node() {
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
