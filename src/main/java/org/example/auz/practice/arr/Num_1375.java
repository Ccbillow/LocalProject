package org.example.auz.practice.arr;

/**
 * 1375. number-of-times-binary-string-is-prefix-aligned
 * https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/description/
 */
public class Num_1375 {

    public int numTimesAllBlue(int[] flips) {
        int res = 0;
        int max = 0;

        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);

            if (max - 1 == i) {
                res++;
            }
        }
        return res;
    }
}
