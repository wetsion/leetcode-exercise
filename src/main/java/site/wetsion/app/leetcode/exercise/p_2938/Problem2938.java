package site.wetsion.app.leetcode.exercise.p_2938;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 2938. 区分黑球与白球
 *
 * 难度：{@link Difficulty#EASY}
 *
 *
 */
public class Problem2938 {

    class Solution {
        public long minimumSteps(String s) {
            // 移动次数
            long steps = 0;
            // 可能不在右侧的黑球数量
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    // 从左往右遍历，如果是1，说明可能是位置错误的黑球，进行计数
                    sum++;
                } else {
                    // 白球要移动的次数就是白球前面的黑球数量，即当前的sum值
                    steps = steps + sum;
                }
            }
            return steps;
        }
    }
}
