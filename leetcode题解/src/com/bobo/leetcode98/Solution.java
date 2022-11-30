package com.bobo.leetcode98;

import com.bobo.leetcode102.TreeNode;

/**
 * @author by bobo
 * @Description leetcode98 验证二叉搜索树
 * @Date 2022/11/25 16:47
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        //深度优先遍历
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean helper(TreeNode node, long low, long up) {
        if (node == null) {
            return true;
        }
        if (node.val <= low || node.val >= up) {
            return false;
        }
        return helper(node.left, low, node.val) && helper(node.right, node.val, up);
    }

    public static void main(String[] args) {

    }
}
