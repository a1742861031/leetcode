package com.bobo.week.week320.test02;

/**
 * @author by bobo
 * @Description TODO
 * @Date 2022/11/20 10:45
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