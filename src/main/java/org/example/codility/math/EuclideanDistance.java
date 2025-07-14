package org.example.codility.math;

/**
 * 实现一个函数，接受两个 double 数组，计算它们之间的欧几里得距离（Euclidean Distance）。
 */
public class EuclideanDistance {

    public static double solution(double[] a, double[] b) {
        double res = 0.0;
        for (int i = 0; i < a.length; i++) {
            double tmp = a[i] - b[i];
            res = res + tmp * tmp;
        }

        return Math.pow(res, 1.0 / 2);
    }
}
