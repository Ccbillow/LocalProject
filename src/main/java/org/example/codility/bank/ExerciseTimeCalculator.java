package org.example.codility.bank;

public class ExerciseTimeCalculator {

    public static double solution(double time, double rate, int day) {
        double res = 0;
        for (int i = 1; i <= day; i++) {
            res = res + time;
            time = time * (1 + rate);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 0.1, 30));

        double dailyTime = 10.0; // 第一天锻炼时间
        double total = 0.0;

        for (int i = 1; i <= 30; i++) {
            total += dailyTime;
            dailyTime *= 1.1; // 每天时间增长10%
        }

        System.out.printf("未来30天总锻炼时间为：%.2f 分钟%n", total);
    }
}
