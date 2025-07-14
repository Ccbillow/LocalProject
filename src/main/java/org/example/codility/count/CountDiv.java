package org.example.codility.count;

public class CountDiv {

    public static int solution(int A, int B, int K) {
        int res = 0;

        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                res++;
            }
        }
        return res;
    }

    public static int div(int A, int B, int K) {
        int countB = B / K;
        int countA = A > 0 ? (A - 1) / K : -1;
        return countB - countA;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, 11, 2)); // 输出 3
        System.out.println(solution(0, 0, 11)); // 输出 1（0 也能被整除）
        System.out.println(solution(10, 10, 5)); // 输出 1
        System.out.println(solution(10, 10, 7)); // 输出 0

        System.out.println();

        System.out.println(div(6, 11, 2)); // 输出 3
        System.out.println(div(0, 0, 11)); // 输出 1（0 也能被整除）
        System.out.println(div(10, 10, 5)); // 输出 1
        System.out.println(div(10, 10, 7)); // 输出 0
    }

}
