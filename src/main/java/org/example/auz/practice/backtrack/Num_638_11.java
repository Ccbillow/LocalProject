package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.management.Query.match;

/**
 * 638. shopping-offers
 * https://leetcode.cn/problems/shopping-offers/description/?show=1
 */
public class Num_638_11 {


    int res = Integer.MAX_VALUE;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        for (int i = 0; i < price.size(); i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < price.size(); j++) {
                if (i == j) {
                    tmp.add(1);
                } else {
                    tmp.add(0);
                }
            }
            tmp.add(price.get(i));
            special.add(tmp);
        }

        dfs(special, needs, 0);
        return res;
    }

    private void dfs(List<List<Integer>> special, List<Integer> needs, int cost) {
        boolean finish = true;
        for (Integer need : needs) {
            if (need > 0) {
                finish = false;
            }
        }
        if (finish) {
            res = Math.min(res, cost);
            return;
        }

        for (List<Integer> sp : special) {
            List<Integer> next = new ArrayList<>();
            boolean valid = true;
            for (int i = 0; i < needs.size(); i++) {
                if (needs.get(i) < sp.get(i)) {
                    valid = false;
                    break;
                }
                next.add(needs.get(i) - sp.get(i));
            }
            if (valid) {
                dfs(special, next, cost + sp.get(needs.size()));
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> special = new ArrayList<>();
        special.add(List.of(3, 0, 5));
        special.add(List.of(1, 2, 10));

        List<Integer> price = List.of(2, 5);

        Num_638_11 test = new Num_638_11();
        test.shoppingOffers(price, special, new ArrayList<>());
    }



}
