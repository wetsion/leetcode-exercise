package site.wetsion.app.leetcode.exercise.p_26;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 26. 删除有序数组中的重复项
 *
 * 难度：{@link Difficulty#EASY}
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 *
 */
public class Problem26 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int[] tmp = new int[nums.length];
            int cur = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != cur) {
                    cur = nums[i];
                    tmp[index] = cur;
                    index++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i < index) {
                    nums[i] = tmp[i];
                } else {
                    nums[i] = -1;
                }
            }
            return index;
        }
    }
}
