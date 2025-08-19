package org.example.auz.practice.tree;

import com.sun.source.tree.Tree;
import org.example.auz.blind75.tool.TreeNode;

import java.util.LinkedList;

/**
 * 662. Maximum Width of Binary Tree
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 */
public class Num_662_1 {

    class Pair {
        TreeNode node;
        int id;

        public Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));

        int max = 0;
        int start = 0;
        int end = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.removeFirst();
                TreeNode cur = pair.node;
                int id = pair.id;
                if (i == 0) {
                    start = id;
                }
                if (i == size - 1) {
                    end = id;
                }

                if (cur.left != null) {
                    queue.add(new Pair(cur.left, id * 2));
                }
                if (cur.right != null) {
                    queue.add(new Pair(cur.right, id * 2 + 1));
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }


}
