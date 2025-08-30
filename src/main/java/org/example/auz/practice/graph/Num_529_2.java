package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 529. Minesweeper
 *
 * https://leetcode.com/problems/minesweeper/description/
 */
public class Num_529_2 {

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int x = click[0];
        int y = click[1];


        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int X = cur[0];
            int Y = cur[1];

            if (board[X][Y] != 'E') {
                continue;
            }

            int mines = countMines(board, X, Y);
            if (mines > 0) {
                board[X][Y] = (char) (mines + '0');
            } else {
                board[X][Y] = 'B';
                for (int[] dir : dirs) {
                    int nX = X + dir[0];
                    int nY = Y + dir[1];
                    if (nX >= 0 && nX < m && nY >= 0 && nY < n && board[nX][nY] == 'E') {
                        q.addLast(new int[]{nX, nY});
                    }
                }
            }
        }
        return board;
    }

    private int countMines(char[][] board, int x, int y) {
        int count = 0;

        int m = board.length, n = board[0].length;

        for (int[] dir : dirs) {
            int X = x + dir[0];
            int Y = y + dir[1];
            if (X >= 0 && X < m && Y >= 0 && Y < m && board[X][Y] == 'M') {
                count++;
            }
        }
        return count;
    }


}
