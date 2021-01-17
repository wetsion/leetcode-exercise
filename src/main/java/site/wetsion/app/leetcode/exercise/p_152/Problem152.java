package site.wetsion.app.leetcode.exercise.p_152;

import lombok.extern.slf4j.Slf4j;
import site.wetsion.app.leetcode.exercise.common.Difficulty;
import site.wetsion.app.leetcode.exercise.p_70.Problem70;

/**
 * 152. 乘积最大子数组 <br/>
 * https://leetcode-cn.com/problems/maximum-product-subarray/  <br/>
 *
 * 难度：{@link Difficulty#MIDDLE}
 *
 * 关键词：动态规划
 *
 * @author wetsion
 * @date 2021/1/15
 */
@Slf4j
public class Problem152 {

    static class Solution {
        /**
         * DP解法
         *
         * 1、定义状态
         * 定义两个状态数组，分别存从0到对应下标的数时，最大值和最小值
         *
         * 2、DP方程
         *
         * 如果当前数大于等于0
         *      取前一个数状态的最大值乘以当前值，再和当前值比较，最大值赋值给当前数状态的最大值
         *      取前一个数状态的最小值乘以当前值，再和当前值比较，最小值赋值给当前数状态的最小值
         * 如果当前数小于0
         *      取前一个数状态的最小值乘以当前值，再和当前值比较，最大值赋值给当前数状态的最大值
         *      取前一个数状态的最大值乘以当前值，再和当前值比较，最小值赋值给当前数状态的最小值
         *
         *  最后取最大值状态数组中的最大值。
         *
         * @param nums 数组
         * @return 最大乘积
         */
        public int maxProduct(int[] nums) {
            int[] max = new int[nums.length];
            int[] min_max = new int[nums.length];
            max[0] = nums[0];
            min_max[0] = nums[0];
            int finalMax = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    max[i] = Integer.max(max[i-1] * nums[i], nums[i]);
                    min_max[i] = Integer.min(min_max[i-1] * nums[i], nums[i]);
                } else {
                    max[i] = Integer.max(min_max[i-1] * nums[i], nums[i]);
                    min_max[i] = Integer.min(max[i-1] * nums[i], nums[i]);
                }
                finalMax = Integer.max(finalMax, max[i]);
            }
            return finalMax;
        }

        /**
         * 暴力递归法
         *
         * 执行用时：109 ms
         * 内存消耗：37.7 MB
         *
         * @param nums 数组
         * @return 最大乘积
         */
        public int maxProduct2(int[] nums) {
            int result = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                if (temp > result) {
                    result = temp;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    temp *= nums[j];
                    if (temp > result) {
                        result = temp;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] input = {2,3,-2,4};
        log.info("输入：{}, 输出: {}", input, new Problem152.Solution().maxProduct2(input));
    }
}
