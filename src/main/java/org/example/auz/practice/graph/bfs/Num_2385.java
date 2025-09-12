package org.example.auz.practice.graph.bfs;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2385. amount-of-time-for-binary-tree-to-be-infected
 * https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected/description/
 */
public class Num_2385 {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    TreeNode startNode = null;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, null, start);

        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(startNode);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(startNode);

        int res = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeFirst();

                if (cur.left != null && visited.add(cur.left)) {
                    q.addLast(cur.left);
                }
                if (cur.right != null && visited.add(cur.right)) {
                    q.addLast(cur.right);
                }
                if (parent.get(cur) != null && visited.add(parent.get(cur))) {
                    q.addLast(parent.get(cur));
                }
            }
            res++;
        }
        return res;
    }

    private void dfs(TreeNode root, TreeNode par, int start) {
        if (root == null) {
            return;
        }

        if (root.val == start) {
            startNode = root;
        }

        parent.put(root, par);
        dfs(root.left, root, start);
        dfs(root.right, root, start);
    }
}
