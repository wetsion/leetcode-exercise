package site.wetsion.app.leetcode.exercise.p_395;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有K个重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 *
 * // TODO 待完善
 * @author weixin
 * @version 1.0
 * @date 2020/5/15 11:09 AM
 */
public class Problem395 {

    static class Solution {

        private int strLength;
        public int longestSubstring(String s, int k) {
            if (s.length() < k) {
                return 0;
            }
            if (k == 1) {
                return s.length();
            }
            int result = 0;
            strLength = s.length();
            Map<String, Integer> map = new HashMap<>();
            int currentUpperLimit = k;
            int currentIndex = 0;
            while(true) {
                if (currentIndex < strLength) {
                    if (currentIndex < currentUpperLimit) {
                        if (currentIndex == currentUpperLimit - 1) {
                            // 说明正好到达上限
                            int preSize = map.keySet().size();
                            int nextIndex = currentIndex + 1;
                            String c = s.substring(currentIndex, nextIndex);
                            insertMap(map, c);
                            int currentSize = map.keySet().size();
                            if (currentSize == preSize) {
                                result = currentUpperLimit;
                                currentUpperLimit++;
                                currentIndex++;
                            } else {
                                currentUpperLimit = currentSize * k;
                                currentIndex++;
                            }
                        } else {
                            int nextIndex = currentIndex + 1;
                            String c = s.substring(currentIndex, nextIndex);
                            insertMap(map, c);
                            currentUpperLimit = map.keySet().size() * k;
                            currentIndex++;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            return result;
        }

        private void insertMap(Map<String, Integer> map, String s) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println("abcd".substring(1, 2));
        System.out.println(new Solution().longestSubstring("bbaaacbd", 3));
    }
}
