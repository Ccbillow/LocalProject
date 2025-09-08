package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 638. shopping-offers
 * https://leetcode.cn/problems/shopping-offers/description/?show=1
 */
public class Num_638 {

    List<List<Integer>> filterSpecial;

    List<Integer> price;

    int n;

    private Map<List<Integer>, Integer> memo;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n = needs.size();
        this.price = price;
        memo = new HashMap<>();

        filterSpecial = new ArrayList<>();
        for (List<Integer> sp : special) {
            int sumItems = 0;
            int sumCosts = 0;
            for (int i = 0; i < n; i++) {
                sumItems = sumItems + sp.get(i);
                sumCosts = sumCosts + sp.get(i) * price.get(i);
            }
            if (sumItems > 0 && sumCosts > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }
        return dfs(needs);
    }

    private int dfs(List<Integer> needs) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost = minCost + needs.get(i) * price.get(i);
        }

        for (List<Integer> sp : filterSpecial) {
            List<Integer> tmp = new ArrayList<>(needs);
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if (sp.get(i) > tmp.get(i)) {
                    valid = false;
                    break;
                }
                tmp.set(i, tmp.get(i) - sp.get(i));
            }

            if (valid) {
                minCost = Math.min(minCost, dfs(tmp) + sp.get(n));
            }
        }

        memo.put(needs, minCost);
        return minCost;
    }


}
