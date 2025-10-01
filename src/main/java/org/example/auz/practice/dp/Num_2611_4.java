package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2611. mice-and-cheese
 * https://leetcode.cn/problems/mice-and-cheese/description/?show=1
 */
public class Num_2611_4 {


    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;

        int res = 0;
        Integer[] diff = new Integer[n];
        for (int i = 0; i < n; i++) {
            res += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }

        Arrays.sort(diff, (a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            res += diff[i];
        }
        return res;
    }

}
