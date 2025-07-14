package org.example.codility.greedy;

import java.security.Key;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *     //Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 *     //Output: [3,3,5,5,6,7]
 *     //Explanation:
 *     //Window position → Max
 *     //[1 3 -1] -3  5  3  6  7 → 3
 *     // 1 [3 -1 -3] 5  3  6  7 → 3
 *     // 1  3 [-1 -3  5] 3  6  7 → 5
 *     // 1  3 -1 [-3  5  3] 6  7 → 5
 *     // 1  3 -1 -3 [5  3  6] 7 → 6
 *     // 1  3 -1 -3  5 [3  6  7] → 7
 */
public class SlidingWindowMaximum {


    public static int[] solution(int[] a, int k) {
        int length = a.length;
        int[] res = new int[length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) {
                deque.removeLast();
            }

            deque.add(i);

            if (i >= k - 1) {
                res[i - k + 1] = a[deque.peekFirst()];
            }
        }

        return res;
    }

    public static int[] compute(int[] a, int k) {
        int[] res = new int[a.length - k + 1];

        for (int i = 0; i <= a.length - k; i++) {
            int max = a[i];
            for (int j = 1; j < k; j++) {
                if (a[i + j] > max) {
                    max = a[i + j];
                }
            }
            res[i] = max;
        }
        
        return res;
    }

    public static int[] max(int[] a, int k) {
        int[] res = new int[a.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            int tmp = a[i];
            for (int j = 0; j < k; j++) {
                int cur = a[i + j];
                tmp = Math.max(tmp, cur);
            }
            res[i] = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(solution(a, 3)));
        System.out.println(Arrays.toString(compute(a, 3)));
        System.out.println(Arrays.toString(max(a, 3)));
    }
}
