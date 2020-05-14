package site.wetsion.app.leetcode.exercise.p_93;

import java.util.*;

/**
 * 93. 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * 回溯法
 *
 * @author weixin
 * @version 1.0
 * @date 2020/5/14 3:17 PM
 */
public class Problem93 {

    static class Solution {

        private char[] chars;

        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            List<String> stringSet = new ArrayList<>();
            chars = s.toCharArray();
            if (chars.length < 4) {
                return result;
            } else if (chars.length == 4) {
                for (int i = 0; i < chars.length; i++) {
                    stringSet.add(String.valueOf(chars[i]));
                }
                result.add(String.join(".", stringSet));
            } else {
                trySet(result, 0, 1, 1, new StringBuilder());
                trySet(result, 0, 2, 1, new StringBuilder());
                trySet(result, 0, 3, 1, new StringBuilder());
            }
            return result;
        }

        private void trySet(List<String> result, int preIndex, int currentIndex, int pointNum, StringBuilder stringBuilder) {
            if (currentIndex - preIndex > 3) {
               return;
            }
            String segment = String.copyValueOf(chars, preIndex, currentIndex - preIndex);
            if (checkSeg(segment)){
                StringBuilder sb1 = new StringBuilder(stringBuilder);
                sb1.append(segment);
                sb1.append(".");
                if (pointNum == 3) {
                    String finalSeg = String.copyValueOf(chars, currentIndex, chars.length - currentIndex);
                    if (checkSeg(finalSeg)) {
                        result.add(sb1 + finalSeg);
                    }
                } else {
                    for (int i = 1; i <= 3; i++) {
                        if (currentIndex + i <= chars.length) {
                            // 放置下一个点，并回溯
                            trySet(result, currentIndex, currentIndex + i, pointNum + 1, sb1);
                        }
                    }
                }
            }
        }

        private boolean checkSeg(String segment) {
            if (segment.length() == 0 || segment.length() > 3 || (segment.charAt(0) == '0' && segment.length() > 1) || Integer.parseInt(segment) > 255) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
//        String s = "25525511135";
        String s = "010010";
//        System.out.println(String.copyValueOf(s.toCharArray(), -1, 2));
        System.out.println(new Solution().restoreIpAddresses(s));
    }
}
