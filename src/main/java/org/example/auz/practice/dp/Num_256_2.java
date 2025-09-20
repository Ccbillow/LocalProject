package org.example.auz.practice.dp;

/**
 * 256
 */
public class Num_256_2 {
    public int minCost(int[][] costs) {
        int n = costs.length;

        int preR = costs[0][0];
        int preB = costs[0][1];
        int preG = costs[0][2];

        for (int i = 1; i < n; i++) {
            int curR = costs[i][0] + Math.min(preB, preG);
            int curB = costs[i][1] + Math.min(preR, preG);
            int curG = costs[i][2] + Math.min(preR, preB);
            preR = curR;
            preB = curB;
            preG = curG;
        }

        return Math.min(preR, Math.min(preB, preG));
    }

}
