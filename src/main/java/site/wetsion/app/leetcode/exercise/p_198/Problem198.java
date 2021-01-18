package site.wetsion.app.leetcode.exercise.p_198;

import site.wetsion.app.leetcode.exercise.common.Difficulty;
import site.wetsion.app.leetcode.exercise.p_213.Problem213;

/**
 * 198. 打家劫舍 <br/>
 *
 * https://leetcode-cn.com/problems/house-robber/  <br/>
 *
 * 难度：{@link Difficulty#EASY}
 *
 * @see Problem213
 * @author wetsion
 * @date 2021/1/18
 */
public class Problem198 {

    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int[] money = new int[nums.length];
            money[0] = nums[0];
            money[1] = Integer.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                money[i] = Integer.max(money[i-1], money[i-2] + nums[i]);
            }
            return money[nums.length-1];
        }
    }
}
