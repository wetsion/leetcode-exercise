package site.wetsion.app.leetcode.exercise.p_80;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * 难度：{@link Difficulty#MIDDLE}
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description
 */
public class Problem80 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int[] tmp = new int[nums.length];
            int cur = -1;
            int ct = 0;
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != cur) {
                    cur = nums[i];
                    ct = 1;
                    tmp[index] = nums[i];
                    index++;
                } else if (ct >= 2) {
                    continue;
                } else {
                    tmp[index] = nums[i];
                    ct ++;
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
