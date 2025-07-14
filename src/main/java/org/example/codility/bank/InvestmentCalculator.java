package org.example.codility.bank;

import java.math.BigDecimal;

/**
 * 一个投资账户初始为 $1000，每年增长 5%。请写一个函数，计算 n 年后账户余额。
 */
public class InvestmentCalculator {

    public static double solution(double amount, double rate, int years) {
        BigDecimal amountTmp = new BigDecimal(amount);
        BigDecimal rateTmp = new BigDecimal(rate);

        BigDecimal res = amountTmp;
        for (int i = 0; i < years; i++) {
            res = BigDecimal.ONE.add(rateTmp).multiply(res);
        }
        return res.doubleValue();
    }

    public static void main(String[] args) {
        //1628.894626777442
        System.out.println(solution(1000, 0.05, 10));
    }
}
