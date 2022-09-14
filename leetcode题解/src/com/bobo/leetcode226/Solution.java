package com.bobo.leetcode226;


/**
 * @author by bobo
 * @Description 翻转二叉树
 * @Date 2022/9/14 9:47 AM
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        //深度优先遍历
        helper(root);
        return root;
    }

    public void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        helper(node.left);
        helper(node.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        new Solution().invertTree(node1); 
    }
}
