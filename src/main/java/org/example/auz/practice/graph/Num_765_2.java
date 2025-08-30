package org.example.auz.practice.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 765. Couples Holding Hands
 * https://leetcode.com/problems/couples-holding-hands/description/?show=1
 */
public class Num_765_2 {


    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }

        int res = 0;
        for (int i = 0; i < row.length; i = i + 2) {
            int first = row[i];

//            int second = first ^ 1;
            int second;
            if (first % 2 == 0) {
                second = first + 1;
            } else {
                second = first - 1;
            }

            int secondIndex = i + 1;
            if (row[secondIndex] != second) {
                res++;

                Integer realIndex = map.get(second);
                int tmp = row[secondIndex];
                row[secondIndex] = row[realIndex];
                row[realIndex] = tmp;
                map.put(row[secondIndex], secondIndex);
                map.put(row[realIndex], realIndex);
            }
        }
        return res;
    }


}
