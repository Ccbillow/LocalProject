package org.example.auz.practice.binary;

/**
 * 1011. capacity-to-ship-packages-within-d-days
 * https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/description/
 */
public class Num_1011 {


    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            int need = needDays(weights, mid);
            if (need > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int needDays(int[] weights, int cap) {
        int need = 1;
        int curLoad = 0;

        for (int w : weights) {
            if (curLoad + w > cap) {
                need++;
                curLoad = 0;
            }

            curLoad = curLoad + w;
        }

        return need;
    }


}
