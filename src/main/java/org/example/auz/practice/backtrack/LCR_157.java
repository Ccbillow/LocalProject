package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR 157. 套餐内商品的排列顺序
 */
public class LCR_157 {

    List<String> res = new ArrayList<>();

    StringBuilder stack = new StringBuilder();

    boolean[] visited;

    public String[] goodsOrder(String goods) {
        char[] arr = goods.toCharArray();
        Arrays.sort(arr);
        visited = new boolean[arr.length];
        dfs(arr);

        String[] arrRes = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arrRes[i] = res.get(i);
        }
        return arrRes;
    }

    private void dfs(char[] arr) {
        if (stack.length() == arr.length) {
            res.add(stack.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
                continue;
            }

            stack.append(arr[i]);
            visited[i] = true;
            dfs(arr);
            visited[i] = false;
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
