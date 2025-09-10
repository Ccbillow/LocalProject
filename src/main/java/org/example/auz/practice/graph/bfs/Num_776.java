package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Num_776 {

    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        int[][] neighbor = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        Deque<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.addLast(start);
        visited.add(start);

        int res = 0;
        String target = "123450";

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();

                if (target.equals(cur)) {
                    return res;
                }

                int id = 0;
                for (int j = 0; j < cur.length(); j++) {
                    if ('0' == cur.charAt(j)) {
                        id = j;
                        break;
                    }
                }

                for (int nei : neighbor[id]) {
                    String newStr = swap(cur.toCharArray(), id, nei);
                    if (!visited.contains(newStr)) {
                        q.addLast(newStr);
                        visited.add(newStr);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private String swap(char[] charArray, int x, int y) {
        char tmp = charArray[x];
        charArray[x] = charArray[y];
        charArray[y] = tmp;
        return String.valueOf(charArray);
    }
}
