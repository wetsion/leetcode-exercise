package site.wetsion.app.leetcode.exercise.p_659;

import java.util.*;

/**
 * 659. 分割数组为连续子序列
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 *
 * // TODO 待做，提交未通过
 * @author weixin
 * @version 1.0
 * @date 2020/5/13 5:44 PM
 */
public class Problem659 {

    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, Set<Integer>> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                Set<Integer> set = map.get(nums[i]);
                if (Objects.isNull(set)) {
                    set = new HashSet<>();
                    set.add(i);
                    map.put(nums[i], set);
                } else {
                    set.add(i);
                    map.put(nums[i], set);
                }
            }
            int count = 0;
            for (int i = 0; i < nums.length;) {
                if (i <= nums.length - 2) {
                    if (nums[i] + 1 == nums[i + 1] && nums[i] + 2 == nums[i + 2]) {
                        i = i + 3;
                        count++;
                    } else {
                        i++;
                    }
                }
            }
            if (count > 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
