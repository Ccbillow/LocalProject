package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1644. Lowest Common Ancestor of a Binary Tree II
 */
public class Num_1644_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);

        boolean foundp = false;
        boolean foundq = false;

        while (!stack.isEmpty()) {
            TreeNode cur = stack.removeLast();

            if (cur == p) {
                foundp = true;
            }
            if (cur == q) {
                foundq = true;
            }

            if (cur.left != null) {
                stack.addLast(cur.left);
                parent.put(cur.left, cur);
            }
            if (cur.right != null) {
                stack.addLast(cur.right);
                parent.put(cur.right, cur);
            }
        }

        if (!foundp || !foundq) {
            return null;
        }

        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = parent.get(q);
        }
        return null;
    }


}
