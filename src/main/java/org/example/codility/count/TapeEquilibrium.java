package org.example.codility.count;

/**
 * A = [3, 1, 2, 4, 3]
 * We can split this tape in 4 places:
 *
 * P = 1: |3 − (1 + 2 + 4 + 3)| = |3 − 10| = 7
 * P = 2: |(3 + 1) − (2 + 4 + 3)| = |4 − 9| = 5
 * P = 3: |(3 + 1 + 2) − (4 + 3)| = |6 − 7| = 1
 * P = 4: |(3 + 1 + 2 + 4) − 3| = |10 − 3| = 7
 *
 * The function should return 1, because that is the minimal difference.
 */
public class TapeEquilibrium {

    public static int solution(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }

        int leftSum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            leftSum = leftSum + arr[i];
            int rightSum = sum - leftSum;
            res = Math.min(res, Math.abs(rightSum - leftSum));
        }

        return res;
    }

    public static int tape(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }

        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            left = left + arr[i];
            int right = sum - left;
            min = Math.min(min, Math.abs(right - left));
        }
        return min;
    }
}
