package site.wetsion.app.leetcode.exercise.p_132;

import lombok.extern.slf4j.Slf4j;
import site.wetsion.app.leetcode.exercise.common.Difficulty;
/**
 * 132. 分割回文串 II   <br/>
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/    <br/>
 *
 * 难度：{@link Difficulty#HARD}  <br/>
 *
 *
 * @author wetsion
 * @date 2021/1/11
 */
@Slf4j
public class Problem132 {

    static class Solution {

        private int cutCount = 0;

        public int minCut(String s) {
            StringBuilder stringBuilder = new StringBuilder(s);
            String reverseStr = stringBuilder.reverse().toString();
            if (reverseStr.equals(s)) {
                return 0;
            }
            int cutCount = 0;
            for (int i = 1; i < s.length(); i++) {
                String left = s.substring(0, i);
                String right = s.substring(i, s.length());
            }
            return 0;
        }

        private boolean cut(String s) {
            StringBuilder stringBuilder = new StringBuilder(s);
            String reverseStr = stringBuilder.reverse().toString();
            if (reverseStr.equals(s)) {
                return true;
            }
            cutCount ++;
            int start = 1;
            boolean left = false;
            boolean right = false;
            while (start < s.length()) {
                left = cut(s.substring(0, start));
                right = cut(s.substring(start, s.length()));
                if ((!left) && (!right)) {
                    start ++;
                } else {

                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        String input = "aab";
        log.info("输入：{}, 输出: {}", input, new Solution().minCut(input));
    }
}
