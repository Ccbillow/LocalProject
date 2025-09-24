package org.example.auz.practice.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 956. tallest-billboard
 * https://leetcode.cn/problems/tallest-billboard/description/
 */
public class Num_956_2 {


    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();

        // key:diff  value:height
        dp.put(0, 0);

        for (int rod : rods) {
            Map<Integer, Integer> cur = new HashMap<>(dp);

            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int diff = entry.getKey();
                int height = entry.getValue();

                int left = diff + rod;
                cur.put(left, Math.max(cur.getOrDefault(left, 0), height + rod));

                int right = diff - rod;
                cur.put(right, Math.max(cur.getOrDefault(right, 0), height));
            }

            dp = cur;
        }
        return dp.get(0);
    }

    public static void main(String[] args) {
        Num_956_2 test = new Num_956_2();

        int[] arr = {1, 2, 3, 4, 5, 6};
        test.tallestBillboard(arr);
    }

}
