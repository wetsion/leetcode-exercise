package site.wetsion.app.leetcode.exercise.p_448;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 448. 找到所有数组中消失的数字
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author weixin
 * @version 1.0
 * @date 2020/5/13 12:00 PM
 */
public class Problem448 {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[Math.abs(nums[i]) - 1] > 0) {
                    nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
                }
            }
            List<Integer> r = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > 0) {
                    r.add(j + 1);
                }
            }
            return r;
        }
    }
}
