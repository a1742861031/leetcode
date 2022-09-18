package com.bobo.leetcode102;

/**
 * @author by bobo
 * @Description ���������ݽṹ
 * @Date 2022/7/8 1:59 PM
 */


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
