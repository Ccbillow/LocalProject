package org.example.auz.practice.arr;

import java.util.Arrays;

/**
 * 1109. corporate-flight-bookings
 *
 * https://leetcode.cn/problems/corporate-flight-bookings/description/
 */
public class Num_1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 0);

        Diff diff = new Diff(arr);
        for (int[] booking : bookings) {
            int from = booking[0] - 1;
            int to = booking[1] - 1;
            int ticket = booking[2];
            diff.increment(from, to, ticket);
        }
        return diff.result();
    }

    class Diff {
        int[] diff;

        public Diff(int[] arr) {
            diff = new int[arr.length];
            diff[0] = arr[0];

            for (int i = 1; i < arr.length; i++) {
                diff[i] = arr[i] - arr[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] = diff[i] + val;
            if (j + 1 < diff.length) {
                diff[j + 1] = diff[j + 1] - val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];

            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
