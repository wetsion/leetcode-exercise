package site.wetsion.app.leetcode.exercise.p_315;

import java.util.Arrays;
import java.util.List;

/**
 * 315：计算右侧小于当前元素的个数
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 *
 * @author weixin
 * @version 1.0
 * @date 2020/5/12 2:21 PM
 */
public class Problem315 {

    class TreeNode {
        int value;
        int count;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            value = val;
            count = 0;
            left = null;
            right = null;
        }
    }
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            Integer[] arr = new Integer[nums.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
            TreeNode root = null;
            for (int i = nums.length - 1; i >= 0; i--) {
                root = insertTree(root, new TreeNode(nums[i]), arr, i);
            }
            return Arrays.asList(arr);
        }

        private TreeNode insertTree(TreeNode parent, TreeNode node, Integer[] arr, int index) {
            if (parent == null) {
                parent = node;
                return parent;
            }
            if (parent.value > node.value) {
                parent.count ++;
                parent.left = insertTree(parent.left, node, arr, index);
            } else {
                arr[index] += parent.count + 1;
                parent.right = insertTree(parent.right, node, arr, index);
            }
            return parent;
        }
    }
}
