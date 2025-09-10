package org.example.auz.practice.graph.bfs;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/?show=1
 */
public class Num_111_2 {

    public int minDepth(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeFirst();

                if (cur.left == null && cur.right == null) {
                    return res + 1;
                }
                if (cur.left != null) {
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    q.addLast(cur.right);
                }
            }
            res++;
        }
        return res;
    }
}
