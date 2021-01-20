package site.wetsion.app.leetcode.exercise.p_221;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 221. 最大正方形 <br/>
 *
 * https://leetcode-cn.com/problems/maximal-square/  <br/>
 *
 * 难度： {@link Difficulty#MIDDLE}
 *
 * @author wetsion
 * @date 2021/1/20
 */
public class Problem221 {

    class Solution {
        /**
         * 将点作为正方形的右下角，以该点向左和向上延伸，左边的点、上面的点以及左上方的点，三个点能确定能否构成正方形，
         * 三个点有一个为0，则不构成正方形，只能这个点自己组成一个边长为1的正方形，
         * 所以取这三个点状态的最小值加1，即为正方形的边长
         *
         * @param matrix
         * @return
         */
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Integer.min(dp[i-1][j], Integer.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                    max = Integer.max(max, dp[i][j]);
                }
            }
            return max * max;
        }
    }
}
