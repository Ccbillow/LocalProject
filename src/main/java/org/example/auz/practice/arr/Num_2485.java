package org.example.auz.practice.arr;

/**
 * 2485. find-the-pivot-integer
 * https://leetcode.cn/problems/find-the-pivot-integer/description/
 */
public class Num_2485 {

    public int pivotInteger(int n) {
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + i;
        }

        int res = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (preSum[i] == preSum[n] - preSum[i] + i) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Num_2485 test = new Num_2485();
        test.pivotInteger(8);
    }
}
