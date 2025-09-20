package org.example.auz.practice.graph.bfs;

import java.util.ArrayList;
import java.util.List;

public class Num_721_3 {


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Num_721_3 test = new Num_721_3();

        List<List<String>> accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("John", "johnnybravo@mail.com"),
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("Mary", "mary@mail.com"));

        List<List<String>> lists = test.accountsMerge(accounts);
        lists.forEach(System.out::println);
    }
}
