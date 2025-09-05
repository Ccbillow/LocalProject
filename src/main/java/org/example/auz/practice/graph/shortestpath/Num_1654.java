package org.example.auz.practice.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 1654. minimum-jumps-to-reach-home
 * <p>
 * https://leetcode.cn/problems/minimum-jumps-to-reach-home/description/
 */
public class Num_1654 {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        for (int i : forbidden) {
            set.add(i);
        }

        int maxLimit = Math.max(x, Arrays.stream(forbidden).max().getAsInt()) + a + b;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 1});

        Set<String> visited = new HashSet<>();
        visited.add("0,1");

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curNode = q.removeFirst();
                int cur = curNode[0];
                int flag = curNode[1];

                if (cur == x) {
                    return res;
                }

                int next = cur + a;
                if (next <= maxLimit && !set.contains(next) && visited.add(next + ",1")) {
                    q.addLast(new int[]{next, 1});
                }

                if (flag == 1) {
                    next = cur - b;
                    if (next >= 0 && !set.contains(next) && visited.add(next + ",0")) {
                        q.addLast(new int[]{next, 0});
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Num_1654 test = new Num_1654();
        int[] arr = {14, 4, 18, 1, 15};
//        System.out.println(test.minimumJumps(arr, 3, 15, 9));

        int[] arr1 = {1, 6, 2, 14, 5, 17, 4};
//        System.out.println(test.minimumJumps(arr1, 16, 9, 7));

        int[] arr2 = {8, 3, 16, 6, 12, 20};
        System.out.println(test.minimumJumps(arr2, 15, 13, 11));
    }
}
