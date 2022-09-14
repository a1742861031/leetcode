package com.bobo.binary_tree;

/**
 * @author by bobo
 * @Description ���������ݽṹ
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
