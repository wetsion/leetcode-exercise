package site.wetsion.app.leetcode.exercise.p_543;

/**
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * 注意会有最大直径不通过根节点的情况
 *
 * @author weixin
 * @version 1.0
 * @CLassName Problem543
 * @date 2020/5/13 5:03 PM
 */
public class Problem543 {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if (root != null) {
                int l = getDepth(root.left);
                int r = getDepth(root.right);
                return l + r > total ? l + r : total;
            }
            return 0;
        }
        private int total = 0;

        private int getDepth(TreeNode node) {
            if (node != null) {
                int leftLength = getDepth(node.left);
                int rightLength = getDepth(node.right);
                if (leftLength + rightLength > total) {
                    total = leftLength + rightLength;
                }
                return Math.max(leftLength, rightLength) + 1;
            }
            return 0;
        }
    }
}
