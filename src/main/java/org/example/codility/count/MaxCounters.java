package org.example.codility.count;

/**
 * MaxCounters
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 *
 * If A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * If A[K] = N + 1, then operation K is max counter.
 *
 *  For example, given integer N = 5 and array A such that:
 * A = [3, 4, 4, 6, 1, 4, 4]
 *
 * The operations are:
 * increase(3) → [0, 0, 1, 0, 0]
 * increase(4) → [0, 0, 1, 1, 0]
 * increase(4) → [0, 0, 1, 2, 0]
 * max counter → [2, 2, 2, 2, 2]
 * increase(1) → [3, 2, 2, 2, 2]
 * increase(4) → [3, 2, 2, 3, 2]
 * increase(4) → [3, 2, 2, 4, 2]
 * The goal is to calculate the value of every counter after all operations.
 */
public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int[] res = new int[N];
        for (int i = 0; i < A.length; i++) {
            if (1 <= A[i] && A[i] <= N) {
                res[A[i] - 1]++;
            } else if (A[i] == N + 1) {
                int max = 0;
                for (int re : res) {
                    max = Math.max(max, re);
                }

                for (int j = 0; j < N; j++) {
                    res[j] = max;
                }
            }
        }
        return res;
    }


    public static int[] counter(int N, int[] A) {
        int[] res = new int[N];
        for (int i = 0; i < A.length; i++) {
            if (1 <= A[i] && A[i] <= N) {
                res[A[i] - 1]++;
            } else if (A[i] == N + 1) {
                int max = 0;
                for (int n : res) {
                    max = Math.max(max, n);
                }

                for (int j = 0; j < N; j++) {
                    res[j] = max;
                }
            }
        }
        return res;
    }
}
