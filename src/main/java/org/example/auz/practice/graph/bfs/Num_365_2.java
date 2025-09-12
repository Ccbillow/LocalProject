package org.example.auz.practice.graph.bfs;

/**
 * 365. water-and-jug-problem
 * https://leetcode.cn/problems/water-and-jug-problem/description/?show=1
 */
public class Num_365_2 {

    public boolean canMeasureWater(int x, int y, int target) {
        if (target == 0) {
            return true;
        }
        if (target > x + y) {
            return false;
        }

        return target % gcd(x, y) == 0;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Num_365_2 test = new Num_365_2();
        test.canMeasureWater(3, 5, 4);
    }
}
