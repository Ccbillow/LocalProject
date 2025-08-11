package org.example.auz.blind75.binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 1235. Maximum Profit in Job Scheduling
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
 */
public class NUm_1235 {

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            arr[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        // endtime, maxProfit
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for (int[] array : arr) {
            int start = array[0];
            int end = array[1];
            int curProfit = array[2];

            int preProfit = map.floorEntry(start).getValue();
            int curTotalProfit = preProfit + curProfit;
            if (curTotalProfit > map.lastEntry().getValue()) {
                map.put(end, curTotalProfit);
            }
        }
        return map.lastEntry().getValue();
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};

        System.out.println(jobScheduling(startTime, endTime, profit));
    }
}
