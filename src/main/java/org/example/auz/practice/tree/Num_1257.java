package org.example.auz.practice.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1257. Smallest Common Region
 */
public class Num_1257 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parent = new HashMap<>();
        for (List<String> region : regions) {
            for (int i = 1; i < region.size(); i++) {
                parent.put(region.get(i), region.get(0));
            }
        }

        Set<String> set = new HashSet<>();
        while (region1 != null) {
            set.add(region1);
            region1 = parent.get(region1);
        }

        while (region2 != null) {
            if (set.contains(region2)) {
                return region2;
            }
            region2 = parent.get(region2);
        }
        return null;
    }

    public static void main(String[] args) {
        Num_1257 test = new Num_1257();

        List<List<String>> regions = List.of(List.of("Earth", "North America", "South America"),
                List.of("North America", "United States", "Canada"),
                List.of("United States", "New York", "Boston"),
                List.of("Canada", "Ontario", "Quebec"),
                List.of("South America", "Brazil"));
        System.out.println(test.findSmallestRegion(regions, "Quebec", "New York"));
    }
}
