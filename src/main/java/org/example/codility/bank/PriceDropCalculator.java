package org.example.codility.bank;

import java.math.BigDecimal;

/**
 * 一个商品价格为 $100，每月降价 10%，编写程序，输出多少个月后价格低于 $50。
 */
public class PriceDropCalculator {

    public static int solution(double price, double rate, double target) {
        BigDecimal bigPrice = new BigDecimal(price);
        BigDecimal bigRate = new BigDecimal(rate);
        BigDecimal bigTarget = new BigDecimal(target);

        int res = 0;
        while (bigPrice.compareTo(bigTarget) >= 0) {
            bigPrice = BigDecimal.ONE.subtract(bigRate).multiply(bigPrice);
            res++;
        }

        return res;
    }

    public static int solution2(double price, double rate, double target) {
        int res = 0;
        while (price >= target) {
            price = (1 - rate) * price;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(100.0, 0.1, 50));
        System.out.println(solution2(100.0, 0.1, 50));
    }

}
