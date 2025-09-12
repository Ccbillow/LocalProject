package org.example.auz.practice.graph.bfs;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Closest Leaf in a Binary Tree
 *
 */
public class Num_742 {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    TreeNode target;

    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        dfs(root, null, k);

        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeFirst();

                if (cur.left == null && cur.right == null) {
                    return cur.val;
                }

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
            step++;
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode par, int k) {
        if (root == null) {
            return;
        }

        if (root.val == k) {
            target = root;
        }
        parent.put(root, par);
        dfs(root.left, root, k);
        dfs(root.right, root, k);
    }
}
