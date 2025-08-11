package org.example.auz.blind75.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */
public class Num_297_2 {
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.poll();

            if (cur == null) {
                builder.append("null,");
            } else {
                builder.append(cur.val).append(",");
                deque.offer(cur.left);
                deque.offer(cur.right);
            }
        }
        return builder.substring(0, builder.length() - 1);
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if ("null".equals(data)) {
            return null;
        }

        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int i = 1;
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pollFirst();
            if (!"null".equals(vals[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                cur.left = left;
                deque.add(left);
            }
            i++;

            if (!"null".equals(vals[i])) {
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                cur.right = right;
                deque.add(right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        right.left = left1;
        right.right = right1;

        System.out.println(serialize(root));

    }

}
