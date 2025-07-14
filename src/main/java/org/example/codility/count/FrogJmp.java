package org.example.codility.count;

public class FrogJmp {

    public static int solution(int X, int Y, int D) {
        int distance = Y - X;
        int jumps = distance / D;
        if (distance % D != 0) {
            jumps++;
        }
        return jumps;
    }

    public static int jump(int X, int Y, int D) {
        int res = 0;
        while (X < Y) {
            X = X + D;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(jump(10, 85, 30));
        System.out.println(solution(10, 85, 30));
    }
}
