package org.example.auz.practice.arr;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * 1996. the-number-of-weak-characters-in-the-game
 * https://leetcode.cn/problems/the-number-of-weak-characters-in-the-game/description/
 */
public class Num_1996 {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });

        int[] heights = new int[properties.length];
        for (int i = 0; i < properties.length; i++) {
            heights[i] = properties[i][1];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;

        for (int height : heights) {
            while (!stack.isEmpty() && height > stack.peekLast()) {
                res++;
                stack.removeLast();
            }
            stack.addLast(height);
        }
        return res;
    }

    public static void main(String[] args) {
        Num_1996 test = new Num_1996();

        int[][] properties = {{5, 5}, {5, 6}, {6, 7}};
        System.out.println(test.numberOfWeakCharacters(properties));
    }
}
