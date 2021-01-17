package site.wetsion.app.leetcode.exercise.p_70;

import lombok.extern.slf4j.Slf4j;
import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 70. 爬楼梯 <br/>
 * https://leetcode-cn.com/problems/climbing-stairs/   <br/>
 *
 * 难度：{@link Difficulty#EASY}
 *
 * 关键词：动态规划
 *
 * @author wetsion
 * @date 2021/1/15
 */
@Slf4j
public class Problem70 {

    static class Solution {
        public int climbStairs(int n) {
            if (n == 0 || n == 1 || n == 2) {
                return n;
            }
            int[] memory = new int[n];
            memory[0] = 1;
            memory[1] = 2;
            for (int i = 2; i < n; i++) {
                memory[i] = memory[i-1] + memory[i-2];
            }
            return memory[n-1];
        }

        public int climbStairs2(int n) {
            if (n  <= 2) {
                return n;
            }
            int one = 2;
            int two = 1;
            int all = 0;
            for (int i = 2; i < n; i++) {
                all = one + two;
                two = one;
                one = all;
            }
            return all;
        }
    }

    public static void main(String[] args) {
        int input = 30;
        log.info("输入：{}, 输出: {}", input, new Problem70.Solution().climbStairs(input));
        log.info("输入：{}, 输出: {}", input, new Problem70.Solution().climbStairs2(input));
    }
}
