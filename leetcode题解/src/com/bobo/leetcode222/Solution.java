package com.bobo.leetcode222;

import com.bobo.leetcode102.TreeNode;

/**
 * @author by bobo
 * @Description leetcode222 完全二叉树的节点个数
 * @Date 2022/11/22 10:07
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int leftDep = 0, rightDep = 0;
        while (leftNode != null) {
            leftDep++;
            leftNode = leftNode.left;
        }
        while (rightNode != null) {
            rightDep++;
            rightNode = rightNode.right;
        }
        if (leftDep == rightDep) {
            return (2 << leftDep) - 1;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    public static void main(String[] args) {

    }
}
