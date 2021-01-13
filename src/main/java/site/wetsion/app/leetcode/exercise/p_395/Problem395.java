package site.wetsion.app.leetcode.exercise.p_395;

import lombok.extern.slf4j.Slf4j;
import site.wetsion.app.leetcode.exercise.common.Difficulty;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有K个重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * 难度 {@link Difficulty#MIDDLE} <br/>
 *
 * 思路：遍历字符串，记录每个字母出现的总次数，找到次数小于k的第一个字母的位置，根据这个位置，将字符串分为左右两个字符串，递归下去，
 * 递归退出条件为中间位置坐标为-1
 *
 * @author weixin
 * @version 1.0
 * @date 2021/01/11 22:40
 */
@Slf4j
public class Problem395 {

    static class Solution {

        public int longestSubstring(String s, int k) {
            char[] arr = s.toCharArray();
            Map<Character, Integer> charCount = new HashMap<>(s.length());
            for (int i = 0; i < arr.length; i++) {
                int lastCount = charCount.getOrDefault(arr[i], 0);
                charCount.put(arr[i], ++lastCount);
            }
            log.info("map: {}", charCount);
            int midPos = -1;
            for (int i = 0; i < arr.length; i++) {
                if (charCount.get(arr[i]) < k) {
                    midPos = i;
                    break;
                }
            }
            if (midPos == -1) {
                return s.length();
            }
            String left = s.substring(0, midPos);
            String right = s.substring(midPos + 1);
            log.info("left: {}, right: {}", left, right);
            int leftCount = longestSubstring(left, k);
            int rightCount = longestSubstring(right, k);
            return Integer.max(leftCount, rightCount);
        }
    }

    public static void main(String[] args) {
//        System.out.println("abcd".substring(1, 2));
        System.out.println(new Solution().longestSubstring("bbaaacbd", 3));
    }
}
