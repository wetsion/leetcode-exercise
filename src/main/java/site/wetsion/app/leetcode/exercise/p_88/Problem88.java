package site.wetsion.app.leetcode.exercise.p_88;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 88. 合并两个有序数组
 *
 * 难度：{@link Difficulty#EASY}
 *
 * https://leetcode.cn/problems/merge-sorted-array/description/
 *
 */
public class Problem88 {

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n == 0) {
                return;
            }
            int merged[] = new int[m+n];
            // 数组1 的指针
            int p1 = 0;
            // 数组2 的指针
            int p2 = 0;
            int tmp;
            while (p1 < m || p2 < n) {
                if (p1 == m) {
                    // p1 走到头了，直接取数组2
                    tmp = nums2[p2];
                    p2++;
                } else if (p2 == n) {
                    // p2 走到头了，直接取数组1
                    tmp = nums1[p1];
                    p1++;
                } else if (nums1[p1] < nums2[p2]) {
                    // 数组1的值小于数组2的值，取数组1的值，并将数组1的指针向后移动
                    tmp = nums1[p1];
                    p1++;
                } else {
                    // 数组2的值小于数组1的值，取数组2的值，并将数组2的指针向后移动
                    tmp = nums2[p2];
                    p2++;
                }
                // 由于两个指针是依次移动，且两个指针相加最大是等于 m+n，
                // 所以同一个时刻 p1+p2-1 就代表了在合并后数组应放置的位置
                merged[p1 + p2 - 1] = tmp;
            }
            for (int i = 0; i < m+n; i++) {
                nums1[i] = merged[i];
            }
        }
    }
}
