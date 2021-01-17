package site.wetsion.app.leetcode.exercise.p_120;

import lombok.extern.slf4j.Slf4j;
import site.wetsion.app.leetcode.exercise.common.Difficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和  <br/>
 * https://leetcode-cn.com/problems/triangle/  <br/>
 *
 * 难度： {@link Difficulty#MIDDLE}
 *
 * 关键词：动态规划
 *
 * @author wetsion
 * @date 2021/1/15
 */
@Slf4j
public class Problem120 {

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int lineCount = triangle.size();
            int[] node = new int[triangle.get(triangle.size()-1).size()];
            for (int k = 0; k < triangle.get(triangle.size()-1).size(); k++) {
                node[k] = triangle.get(triangle.size()-1).get(k);
            }
            for (int i = lineCount - 2; i  >= 0; i--) {
                List<Integer> columns = triangle.get(i);
                for (int j = 0; j < columns.size(); j++) {
                    int current = columns.get(j) + Integer.min(node[j], node[j + 1]);
                    node[j] = current;
                }
            }
            return node[0];
        }
    }

    public static void main(String[] args) {
//        log.info("输入：{}, 输出: {}", input, new Problem120.Solution().minimumTotal(Arrays.));
    }
}
