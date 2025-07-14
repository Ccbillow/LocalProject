package org.example.codility.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 一个贷款每月还款 $500，总额 $10,000，利率年化 6%。请写函数计算还清贷款需要多少月。
 */
public class LoanCalculator {

    public static int solution(double monthlyPayment, double amount, double yearlyRate) {
        BigDecimal bigMonthlyPayment = new BigDecimal(monthlyPayment);
        BigDecimal bigAmount = new BigDecimal(amount);
        BigDecimal bigYearlyRate = new BigDecimal(yearlyRate);

        BigDecimal bigMonthlyRate = bigYearlyRate.divide(new BigDecimal(12), 2, RoundingMode.HALF_UP);
        int res = 0;

        while (bigAmount.compareTo(BigDecimal.ZERO) > 0) {
            bigAmount = bigAmount.multiply(BigDecimal.ONE.add(bigMonthlyRate)).subtract(bigMonthlyPayment);
            res++;
        }
        return res;
    }
}
