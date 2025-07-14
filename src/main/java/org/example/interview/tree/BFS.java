package org.example.interview.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        List<List<Integer>> bfs = levelOrder(TreeNode.init());
        System.out.println(bfs);
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.getValue());
                if (head.getLeft() != null) {
                    queue.offer(head.getLeft());
                }
                if (head.getRight() != null) {
                    queue.offer(head.getRight());
                }
            }
            result.add(level);
        }
        return result;
    }
}
