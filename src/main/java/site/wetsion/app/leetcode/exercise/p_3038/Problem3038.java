package site.wetsion.app.leetcode.exercise.p_3038;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 3038. 相同分数的最大操作数目
 *
 * 难度：{@link Difficulty#EASY}
 *
 * https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/description/
 */
public class Problem3038 {

    class Solution {
        public int maxOperations(int[] nums) {
            int sum = nums[0] + nums[1];
            int ct = 1;
            for (int i = 2; i < nums.length -1; i=i+2) {
                if (nums[i] + nums[i+1] == sum) {
                    ct ++;
                } else {
                    break;
                }
            }
            return ct;
        }
    }
}
