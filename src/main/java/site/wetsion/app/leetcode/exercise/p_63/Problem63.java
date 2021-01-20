package site.wetsion.app.leetcode.exercise.p_63;

import site.wetsion.app.leetcode.exercise.common.Difficulty;
import site.wetsion.app.leetcode.exercise.p_62.Problem62;

/**
 * 63. 不同路径 II  <br/>
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/ <br/>
 *
 * 难度：{@link Difficulty#MIDDLE}
 *
 * @see Problem62
 * @author wetsion
 * @date 2021/1/19
 */
public class Problem63 {

    class Solution {
        /**
         * 本题和62题类似，增加了在格子上设置障碍，整体思路还是和62题一样，
         * 当前格子只能从上方和左侧走过来，路径数也就等于上方格子的路径数加上左侧格子的路径数。
         * 区别在于，增加判断是否有障碍物，有障碍物则这个格子的路径数为0，
         * 另外对于最左边一列和最上面一行需要额外考虑一下，之前也说了，这两个区间的格子的路径数都为1，
         * 即只有起点直达格子的一种走法，只要有障碍物，则后面的格子路径也就都为0了，所以需要额外判断下前一个格子的路径数。
         * @param obstacleGrid
         * @return
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] point = new int[m][n];
            point[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            for (int i = 1; i < m; i++) {
                point[i][0] = obstacleGrid[i][0] == 1 ? 0 : point[i-1][0];
            }
            for (int i = 1; i < n; i++) {
                point[0][i] = obstacleGrid[0][i] == 1 ? 0 : point[0][i-1];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    point[i][j] = obstacleGrid[i][j] == 1 ? 0 : point[i][j - 1] + point[i - 1][j];
                }
            }
            return point[m - 1][n - 1];
        }
    }
}
