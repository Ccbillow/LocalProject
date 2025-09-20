package org.example.auz.practice.arr;

/**
 * 1217. minimum-cost-to-move-chips-to-the-same-position
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/description/
 */
public class Num_1217 {

    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
