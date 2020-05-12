package site.wetsion.app.leetcode.exercise.p_836;

/**
 * 836：矩形重叠
 * https://leetcode-cn.com/problems/rectangle-overlap/
 *
 *
 * @author weixin
 * @version 1.0
 * @date 2020/5/12 2:26 PM
 */
public class Problem836 {
    class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            int r1x1 = rec1[0];
            int r1y1 = rec1[1];
            int r1x2 = rec1[2];
            int r1y2 = rec1[3];

            int r2x1 = rec2[0];
            int r2y1 = rec2[1];
            int r2x2 = rec2[2];
            int r2y2 = rec2[3];

            if (r1x1 >= r2x2 || r2x1 >= r1x2) {
                return false;
            } else {
                return r1y1 < r2y2 && r2y1 < r1y2;
            }
        }
    }
}
