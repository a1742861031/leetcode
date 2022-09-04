package com.bobo.leetcode102;

/**
 * @author by bobo
 * @Description 二叉树数据结构
 * @Date 2022/7/8 1:59 PM
 */


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
