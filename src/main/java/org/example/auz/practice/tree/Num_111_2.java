package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * dfs
 */
public class Num_111_2 {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int depth = 1;
        int minDepth = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();

                if (cur.left == null && cur.right == null) {
                    minDepth = Math.min(minDepth, depth);
                }

                if (cur.left != null) {
                    deque.add(cur.left);
                }
                if (cur.right != null) {
                    deque.add(cur.right);
                }
            }
            depth++;
        }
        return minDepth;
    }

}
