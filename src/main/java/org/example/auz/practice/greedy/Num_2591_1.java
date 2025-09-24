package org.example.auz.practice.greedy;

/**
 * 2591. distribute-money-to-maximum-children
 * https://leetcode.cn/problems/distribute-money-to-maximum-children/description/
 */
public class Num_2591_1 {

    public int distMoney(int money, int children) {
        money = money - children;
        if (money < 0) {
            return -1;
        }

        int res = 0;

        for (int i = 0; i < children; i++) {
            if (money >= 7) {
                res++;
                money = money - 7;
            } else {
                if (money != 3) {
                    return res;
                } else {
                    if (i == children - 1) {
                        return res - 1;
                    } else {
                        return res;
                    }
                }
            }
        }

        if (money > 0) {
            res--;
        }

        return res;
    }
}
