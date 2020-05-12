package site.wetsion.app.leetcode.exercise.p_315;

import java.util.ArrayList;
import java.util.List;

/**
 * 315：计算右侧小于当前元素的个数
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 *
 * @author weixin
 * @version 1.0
 * @date 2020/5/12 2:21 PM
 */
public class Problem315 {
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int count = 0;
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] < nums[i]) {
                        count ++;
                    }
                }
                list.add(count);
            }
            return list;
        }
    }
}
