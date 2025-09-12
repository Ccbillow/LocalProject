package org.example.auz.practice.graph.bfs;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 662. 二叉树最大宽度
 * https://labuladong.online/algo/problem-set/bfs/#slug_maximum-width-of-binary-tree
 */
public class Num_662_2 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<Pair> q = new ArrayDeque<>();
        q.addLast(new Pair(root, 1));

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;

            for (int i = 0; i < size; i++) {
                Pair pair = q.removeFirst();

                if (i == 0) {
                    start = pair.id;
                }
                if (i == size - 1) {
                    end = pair.id;
                }

                if (pair.node.left != null) {
                    q.addLast(new Pair(pair.node.left, pair.id * 2));
                }
                if (pair.node.right != null) {
                    q.addLast(new Pair(pair.node.right, pair.id * 2 + 1));
                }
            }
            res = Math.max(res, end - start + 1);

        }
        return res;
    }

    class Pair {
        TreeNode node;
        int id;

        public Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }
}
