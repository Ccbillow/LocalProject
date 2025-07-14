package org.example.codility.bank;

import java.math.BigDecimal;

/**
 * 你投资 $5,000，年利率 4%，每年复利一次。请计算 10 年后的总金额。
 */
public class CompoundInterest {

    public static double solution(double amount, double rate, int years) {
        BigDecimal bigAmount = new BigDecimal(amount);
        BigDecimal bigRate = new BigDecimal(rate);

        BigDecimal total = bigAmount;
        for (int i = 0; i < years; i++) {
            total = BigDecimal.ONE.add(bigRate).multiply(total);
        }

        return total.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(solution(5000, 0.04, 10));
    }
}
