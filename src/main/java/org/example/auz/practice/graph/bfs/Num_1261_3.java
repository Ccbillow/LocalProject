package org.example.auz.practice.graph.bfs;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 1261. 在受污染的二叉树中查找元素
 *
 * https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/description/
 *
 * bfs
 */
public class Num_1261_3 {

    Set<Integer> set = new HashSet<>();

    public Num_1261_3(TreeNode root) {
        bfs(root, 0);
    }

    private void bfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        root.val = val;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.removeFirst();
            set.add(cur.val);

            if (cur.left != null) {
                cur.left.val = 2 * cur.val + 1;
                q.addLast(cur.left);
            }
            if (cur.right != null) {
                cur.right.val = 2 * cur.val + 2;
                q.addLast(cur.right);
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
