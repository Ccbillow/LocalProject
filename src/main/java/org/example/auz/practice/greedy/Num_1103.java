package org.example.auz.practice.greedy;

/**
 * 1103. 分糖果 II
 * https://leetcode.cn/problems/distribute-candies-to-people/description/
 */
public class Num_1103 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];

        int round = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies < 0) {
                    break;
                }
                if (candies < i + round) {
                    res[i] = res[i] + candies;
                } else {
                    res[i] = res[i] + round + i;
                }
                candies = candies - round - i;
            }
            round = round + num_people;

        }

        return res;
    }

    public static void main(String[] args) {
        Num_1103 test = new Num_1103();
        test.distributeCandies(10, 3);
    }
}
