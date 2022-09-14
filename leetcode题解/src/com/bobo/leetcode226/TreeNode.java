package com.bobo.leetcode226;

/**
 * @author by bobo
 * @Description Definition for a binary tree node.
 * @Date 2022/9/14 9:48 AM
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
