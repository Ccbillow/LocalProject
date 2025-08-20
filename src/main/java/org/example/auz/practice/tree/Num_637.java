package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. Average of Levels in Binary Tree
 * https://leetcode.cn/problems/average-of-levels-in-binary-tree/
 */
public class Num_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        List<Double> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            double level = 0;
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.removeFirst();

                level = level + cur.val;
                sum = sum + 1;
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }

            res.add(level / sum);
        }
        return res;
    }
}
