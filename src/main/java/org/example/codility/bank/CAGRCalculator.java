package org.example.codility.bank;

/**
 * 某基金 3 年平均年化回报为 8%、-2%、10%。请计算年均复合收益率（CAGR）。
 */
public class CAGRCalculator {

    public static double solution(double[] returns) {
        double normal = 1.0;
        for (double tmp : returns) {
            normal = normal * (1 + tmp);
        }

        return Math.pow(normal, 1.0 / returns.length) - 1;
    }

    public static void main(String[] args) {
        double[] returns = {0.08, -0.02, 0.10};
        double cagr = solution(returns);
        System.out.printf("年均复合收益率 (CAGR): %.2f%%\n", cagr * 100);
    }
}
