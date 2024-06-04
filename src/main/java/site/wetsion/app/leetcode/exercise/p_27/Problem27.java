package site.wetsion.app.leetcode.exercise.p_27;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 27. 移除元素
 *
 * 难度：{@link Difficulty#EASY}
 *
 * https://leetcode.cn/problems/remove-element/description/
 */
public class Problem27 {

    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }
            int[] tmp = new int[nums.length];
            int count = 0;
            int tail = nums.length - 1;
            int head = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    tmp[tail] = -1;
                    tail--;
                } else {
                    count++;
                    tmp[head] = nums[i];
                    head++;
                }
            }
            for (int i = 0; i < tmp.length; i++) {
                nums[i] = tmp[i];
            }
            return count;
        }
    }

}
