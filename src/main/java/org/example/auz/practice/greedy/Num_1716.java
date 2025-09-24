package org.example.auz.practice.greedy;

/**
 * 1716. calculate-money-in-leetcode-bank
 * https://leetcode.cn/problems/calculate-money-in-leetcode-bank/description/
 */
public class Num_1716 {

    public int totalMoney(int n) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            int week = i / 7;
            int day = i % 7 + 1;

            int tmp = week + day;

            res = res + tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        Num_1716 test = new Num_1716();
        test.totalMoney(10);
    }

}
