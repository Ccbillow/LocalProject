package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2611. mice-and-cheese
 * https://leetcode.cn/problems/mice-and-cheese/description/?show=1
 */
public class Num_2611_3 {


    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;

        int[][] diff = new int[n][2];
        for (int i = 0; i < n; i++) {
            diff[i][0] = reward1[i] - reward2[i];
            diff[i][1] = i;
        }
        Arrays.sort(diff, (a, b) -> b[0] - a[0]);

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += reward1[diff[i][1]];
        }
        for (int i = k; i < n; i++) {
            sum += reward2[diff[i][1]];
        }
        return sum;
    }



}
