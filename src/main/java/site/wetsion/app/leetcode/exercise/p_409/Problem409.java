package site.wetsion.app.leetcode.exercise.p_409;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 *
 * https://leetcode.cn/problems/longest-palindrome/description/
 */
public class Problem409 {

    class Solution {
        public int longestPalindrome(String s) {
            if (s == null) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            Map<Integer, Integer> zip = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                int index = getIndex(s.charAt(i));
                zip.put(index, zip.getOrDefault(index, 0) + 1);
            }
            boolean existOdd = false;
            Map<Integer, Integer> oddMap = new HashMap<>();
            int result = 0;
            for (Map.Entry<Integer, Integer> entry : zip.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    oddMap.put(entry.getKey(), entry.getValue());
                } else {
                    result += entry.getValue();
                }
            }
            if (oddMap.size() > 0) {
                int maxLenKey = 0;
                int maxLen = 0;
                for (Map.Entry<Integer, Integer> entry : oddMap.entrySet()) {
                    if (entry.getValue() >= maxLenKey) {
                        maxLen = entry.getValue();
                        maxLenKey = entry.getKey();
                    }
                }
                for (Map.Entry<Integer, Integer> entry : oddMap.entrySet()) {
                    if (entry.getKey().equals(maxLenKey)) {
                        result += entry.getValue();
                    } else {
                        result += entry.getValue() - 1;
                    }
                }
            }
            return result;
        }

        private int getIndex(char c) {
            return c - 'a';
        }
    }
}
