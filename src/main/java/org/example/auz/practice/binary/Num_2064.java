package org.example.auz.practice.binary;

/**
 * 2064. minimized-maximum-of-products-distributed-to-any-store
 * https://leetcode.cn/problems/minimized-maximum-of-products-distributed-to-any-store/description/
 */
public class Num_2064 {

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        for (int q : quantities) {
            right = Math.max(q, right);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            int need = need(quantities, mid);

            if (need > n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int need(int[] quantities, int cap) {
        int need = 0;

        for (int q : quantities) {
            int cur = q;
            while (cur > 0) {
                cur = cur - cap;
                need++;
            }
        }
        return need;
    }
}
