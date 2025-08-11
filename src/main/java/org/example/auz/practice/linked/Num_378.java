package org.example.auz.practice.linked;

import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */
public class Num_378 {

    public int kthSmallest(int[][] matrix, int k) {
        // pq record element and its index
        PriorityQueue<int[]> pq = new PriorityQueue<>(matrix.length, (a, b) -> a[0] - b[0]);

        // add all first element and its index
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        int res = -1;
        // find k
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            res = cur[0];
            k--;

            // add next element into pq
            int i = cur[1];
            int j = cur[2];
            if (j < matrix[i].length - 1) {
                pq.offer(new int[]{matrix[i][j + 1], i, j + 1});
            }
        }
        return res;
    }
}
