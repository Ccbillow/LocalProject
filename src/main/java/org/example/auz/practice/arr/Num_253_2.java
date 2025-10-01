package org.example.auz.practice.arr;

/**
 * 253. Meeting Rooms II
 */
public class Num_253_2 {

    public int minMeetingRooms(int[][] meetings) {
        int maxTime = 0;
        for (int[] m : meetings) {
            maxTime = Math.max(maxTime, m[1]);
        }

        int[] arr = new int[maxTime + 2];
        Diff diff = new Diff(arr);

        for (int[] m : meetings) {
            diff.increment(m[0], m[1] - 1, 1);
        }

        int[] roomsAtTime = diff.result();

        int max = 0;
        for (int r : roomsAtTime) {
            max = Math.max(max, r);
        }
        return max;
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

        void increment(int i, int j, int val) {
            diff[i] = diff[i] + val;
            if (j + 1 < diff.length) {
                diff[j + 1] = diff[j + 1] - val;
            }
        }

        int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
