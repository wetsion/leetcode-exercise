package site.wetsion.app.leetcode.exercise.p_62;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 62. 不同路径 <br/>
 *
 * https://leetcode-cn.com/problems/unique-paths/ <br/>
 *
 * 难度：{@link Difficulty#MIDDLE} <br/>
 *
 * 关键词：动态规划
 *
 * @author wetsion
 * @date 2021/1/19
 */
public class Problem62 {

    class Solution {
        /**
         *
         * 由于只能向右或者向下，所以某一个格子的来源只能是来自上方或者左侧，所以路径数量是到上方格子的
         * 路径数加上到左侧格子的路径数，而对于二维格子，最左边和最上面的每个格子的路径数都是1，因为从起点到这些格子只有一种直达的路径。
         *
         * @param m
         * @param n
         * @return
         */
        public int uniquePaths(int m, int n) {
            int[][] point = new int[m][n];
            point[0][0] = 1;
            for (int i = 1; i < m; i++) {
                point[i][0] = 1;
            }
            for (int i = 1; i < n; i++) {
                point[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    point[i][j] = point[i][j - 1] + point[i - 1][j];
//                System.out.println(String.format("point[%d][%d]: %d", i, j, point[i][j]));
                }
            }
            return point[m - 1][n - 1];
        }

    }
}
