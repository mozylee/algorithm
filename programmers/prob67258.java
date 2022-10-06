package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class prob67258 {
    static class Solution {
        public int[] solution(String[] gems) {
            Map<String, Integer> gemMap = initMap(gems);
            int gemSize = gemMap.size();

            ArrayList<int[]> pairs = new ArrayList<>();
            int gemCount = 0;
            int left = 0, right = 0;
            int length = Integer.MAX_VALUE;
            while (right <= gems.length && left <= right) {
                if (gemCount >= gemSize) {
                    gemMap.compute(gems[left], (k, v) -> v - 1);
                    gemCount += gemMap.get(gems[left++]) > 0 ? 0 : -1;
                } else {
                    if (right == gems.length) {
                        break;
                    }
                    gemMap.compute(gems[right], (k, v) -> v + 1);
                    gemCount += gemMap.get(gems[right++]) > 1 ? 0 : 1;
                }

                if (gemCount == gemSize && length >= right - left) {
                    if (length > right - left) {
                        pairs.clear();
                        length = right - left;
                    }

                    pairs.add(new int[] { left + 1, right });
                }
            }
            
            return Collections.min(pairs, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        }

        private Map<String, Integer> initMap(String[] gems) {
            Map<String, Integer> gemMap = new HashMap<>();
            for (String gem : gems) {
                if (gemMap.containsKey(gem)) {
                    continue;
                }
                gemMap.put(gem, 0);
            }

            return gemMap;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] gems = {
                { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" }, // [3, 7]
                { "AA", "AB", "AC", "AA", "AC" }, // [1, 3]
                { "XYZ", "XYZ", "XYZ" }, // [1, 1]
                { "ZZZ", "YYY", "NNNN", "YYY", "BBB" }, // [1, 5]
                { "XXX" }, // [1, 1]
                { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA", "RUBY" } // [6, 9]
        };

        for (String[] g : gems) {
            System.out.println(Arrays.toString(s.solution(g)));
        }
    }
}