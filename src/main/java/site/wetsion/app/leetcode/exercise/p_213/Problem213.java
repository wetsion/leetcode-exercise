package site.wetsion.app.leetcode.exercise.p_213;

import site.wetsion.app.leetcode.exercise.common.Difficulty;
import site.wetsion.app.leetcode.exercise.p_198.Problem198;

/**
 * 213. 打家劫舍 II  <br/>
 *
 * https://leetcode-cn.com/problems/house-robber-ii/  <br/>
 *
 * 难度：{@link Difficulty#MIDDLE}
 *
 * @see Problem198
 * @author wetsion
 * @date 2021/1/18
 */
public class Problem213 {

    static class Solution {
        /**
         *
         * 和198题类似，只不过本题是环形，首尾不能同时取值，所以将环拆成两个数组，一个是从0到n-1，一个是从1到n，
         * 两个数组的解法则和198题一样，比较两个数组的最大值即可。
         *
         * @param nums 环形数组
         * @return 最大值
         */
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int[] money1 = new int[nums.length];
            int[] money2 = new int[nums.length];
            money1[0] = 0;
            money2[0] = nums[0];
            money1[1] = nums[1];
            money2[1] = Integer.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                money1[i] = Integer.max(money1[i-1], money1[i-2] + nums[i]);

                if (i == nums.length-1) {
                    money2[i] = Integer.max(money2[i-1], money2[i-2] + 0);
                } else {
                    money2[i] = Integer.max(money2[i-1], money2[i-2] + nums[i]);
                }
            }
            return Integer.max(money1[nums.length-1], money2[nums.length-1]);
        }
    }
}
