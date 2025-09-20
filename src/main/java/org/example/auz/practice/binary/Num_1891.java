package org.example.auz.practice.binary;

/**
 * 1891 — Cutting Ribbons
 *
 */
public class Num_1891 {

    public int maxLength(int[] ribbons, int k) {
        int left = 1;
        int right = 0;

        for (int r : ribbons) {
            right = Math.max(right, r);
        }

        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int count = count(ribbons, mid);

            if (count >= k) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return res;
    }

    private int count(int[] ribbons, int cap) {
        int count = 0;
        for (int r : ribbons) {
            count = count + r / cap;
        }
        return count;
    }
}
