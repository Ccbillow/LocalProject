package org.example.codility.greedy;

import java.util.Arrays;

public class Triangle {

    public static boolean solution(int[] A) {
        if (A.length < 3) {
            return false;
        }

        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] >= 0 && A[i] + A[i + 1] > A[i + 2]) {
                return true;
            }
        }

        return false;
    }

    public static boolean check(int[] A) {
        if (A.length < 3) {
            return false;
        }

        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] > 0 && A[i] + A[i + 1] > A[i + 2]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};  // 输出 1（例如 10, 8, 5 可构成三角形）
        int[] B = {10, 50, 5, 1};        // 输出 0（没有任意三条边满足三角形条件）
        int[] C = {-3, -2, -1};          // 输出 0（不能有负边）

        System.out.println(solution(A));
        System.out.println(solution(B));
        System.out.println(solution(C));
        System.out.println();
        System.out.println(check(A));
        System.out.println(check(B));
        System.out.println(check(C));
    }
}
