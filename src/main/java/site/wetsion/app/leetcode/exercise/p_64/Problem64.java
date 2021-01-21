package site.wetsion.app.leetcode.exercise.p_64;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 64.最小路径和  <br/>
 * https://leetcode-cn.com/problems/minimum-path-sum/  <br/>
 *
 * 难度：{@link Difficulty#MIDDLE}
 *
 * 关键词：动态规划
 *
 * @author wetsion
 * @date 2021/1/21
 */
public class Problem64 {

    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j > 0) {
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    } else if (j == 0 && i > 0) {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    } else if (i == 0 && j == 0){
                        dp[i][j] = grid[0][0];
                    } else {
                        dp[i][j] = grid[i][j] + Integer.min(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }
}
