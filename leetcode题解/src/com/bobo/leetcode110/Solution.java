package com.bobo.leetcode110;

import com.bobo.leetcode102.TreeNode;

/**
 * @author by bobo
 * @Description leetcode110  平衡二叉树
 * @Date 2022/11/22 10:23
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;

    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //计算左子树的最大高度
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return leftHeight;
        }
        //计算右子树的最大高度
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return rightHeight;
        }
        int result;
        //判断是否符合条件
        if (Math.abs(rightHeight - leftHeight) > 1) {
            result = -1;
        } else {
            result = 1 + Math.max(rightHeight, leftHeight);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
