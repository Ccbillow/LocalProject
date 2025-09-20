package org.example.auz.practice.greedy;

import java.util.Arrays;

/**
 * 1710. maximum-units-on-a-truck
 * https://leetcode.cn/problems/maximum-units-on-a-truck/description/
 */
public class Num_1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int res = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int[] boxType = boxTypes[i];

            if (truckSize - boxType[0] < 0) {
                res = res + truckSize * boxType[1];
                break;
            }

            truckSize = truckSize - boxType[0];
            res = res + boxType[0] * boxType[1];
        }
        return res;
    }

    public static void main(String[] args) {
        Num_1710 test = new Num_1710();

        int[][] arr = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        test.maximumUnits(arr, 10);
    }
}
