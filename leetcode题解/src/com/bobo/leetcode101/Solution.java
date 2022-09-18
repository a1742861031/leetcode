package com.bobo.leetcode101;

import com.bobo.leetcode102.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author by bobo
 * @Description 101 对称二叉树
 * @Date 2022/9/14 6:27 PM
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.remove();
            TreeNode node2 = queue.remove();
            if (node1 == null && node2 != null) {
                return false;
            }
            if (node2 == null && node1 != null) {
                return false;
            }
            if (node1 != null && node2 != null) {
                if (node1.val != node2.val) {
                    return false;
                }
                queue.add(node1.left);
                queue.add(node2.right);
                queue.add(node1.right);
                queue.add(node2.left);
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        boolean outSide = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outSide && inside;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        boolean symmetric = new Solution().isSymmetric(node1);
        System.out.println(symmetric);
    }
}
