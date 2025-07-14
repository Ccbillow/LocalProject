package org.example.codility.math;

/**
 * 计算一个正整数 n 的阶乘。
 */
public class MultipleN {

    public static int solution(int N) {
        int res = 1;
        for (int i = 1; i <= N; i++) {
            res = res * i;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
