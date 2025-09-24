package org.example.auz.practice.arr;

import java.util.PriorityQueue;

/**
 * 2333. minimum-sum-of-squared-difference
 * https://leetcode.cn/problems/minimum-sum-of-squared-difference/description/
 */
public class Num_2333_1 {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        int k = k1 + k2;

        PriorityQueue<Long> diff = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for (int i = 0; i < n; i++) {
            diff.add((long) Math.abs(nums1[i] - nums2[i]));
        }

        while (k > 0 && diff.peek() > 0) {
            Long cur = diff.poll();
            diff.add(cur - 1);
            k--;
        }

        long res = 0;
        while (!diff.isEmpty()) {
            Long cur = diff.poll();
            res = res + cur * cur;
        }

        return res;
    }

    public static void main(String[] args) {
        Num_2333_1 test = new Num_2333_1();
        int[] arr1 = {1, 4, 10, 12};
        int[] arr2 = {5, 8, 6, 9};
        test.minSumSquareDiff(arr1, arr2, 1, 1);

    }
}
