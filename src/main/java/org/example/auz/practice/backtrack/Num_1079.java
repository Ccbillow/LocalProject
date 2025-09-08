package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1079. letter-tile-possibilities
 * https://leetcode.cn/problems/letter-tile-possibilities/description/?show=1
 */
public class Num_1079 {

    int res = 0;
    StringBuilder stack = new StringBuilder();
    boolean[] visited;

    public int numTilePossibilities(String tiles) {
        if (tiles.isEmpty()) {
            return 0;
        }

        visited = new boolean[tiles.length()];

        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        backtrack(chars, visited);
        return res;
    }

    private void backtrack(char[] arr, boolean[] visited) {
        if (!stack.isEmpty()) {
            res++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
                continue;
            }

            stack.append(arr[i]);
            visited[i] = true;

            backtrack(arr, visited);

            visited[i] = false;
            stack.deleteCharAt(stack.length() - 1);
        }
    }

}
