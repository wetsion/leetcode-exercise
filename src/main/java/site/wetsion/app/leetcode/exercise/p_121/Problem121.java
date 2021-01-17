package site.wetsion.app.leetcode.exercise.p_121;

import lombok.extern.slf4j.Slf4j;
import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 121. 买卖股票的最佳时机 <br/>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 难度：{@link Difficulty#EASY}
 *
 * @author wetsion
 * @date 2021/1/17
 */
@Slf4j
public class Problem121 {

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }
            int result = 0;

            // 定义状态，二维数组，第一维代表天数，第二维只有3中可能的值，0：没有交易，1：买入股票，2：卖出股票
            int profit[][] = new int[prices.length][3];
            profit[0][0] = 0;
            profit[0][1] = -prices[0];
            profit[0][2] = 0;

            for (int i = 1; i < prices.length; i++) {
                profit[i][0] = profit[i-1][0];
                profit[i][1] = Integer.max(profit[i-1][1], profit[i-1][0] - prices[i]);
                profit[i][2] = profit[i-1][1] + prices[i];
                result = Integer.max(result, Integer.max(profit[i][0], Integer.max(profit[i][2], profit[i][1])));
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};
        log.info("输入：{}, 输出: {}", input, new Problem121.Solution().maxProfit(input));
    }
}
