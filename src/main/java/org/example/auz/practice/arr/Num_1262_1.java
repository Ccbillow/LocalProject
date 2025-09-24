package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * greatest-sum-divisible-by-three
 * https://leetcode.cn/problems/greatest-sum-divisible-by-three/description/?show=1
 */
public class Num_1262_1 {

    public int maxSumDivThree(int[] nums) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();


        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (n % 3 == 1) one.add(n);
            if (n % 3 == 2) two.add(n);
        }

        if (sum % 3 == 0) return sum;

        Collections.sort(one);
        Collections.sort(two);

        int target = sum % 3;
        int res = 0;

        if (target == 1) {
            // del (1-%1) or (2-%2)
            if (one.size() >= 1) res = Math.max(res, sum - one.get(0));
            if (two.size() >= 2) res = Math.max(res, sum - two.get(0) - two.get(1));
        } else if (target == 2) {
            // del (2-%1) or (1-%2)
            if (one.size() >= 2) res = Math.max(res, sum - one.get(0) - one.get(1));
            if (two.size() >= 1) res = Math.max(res, sum - two.get(0));
        }
        return res;
    }
}
