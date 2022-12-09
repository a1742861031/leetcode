package com.bobo.leetcode112;

import com.bobo.leetcode102.TreeNode;

/**
 * @author by bobo
 * @Description leetcode 112 路径总和
 * @Date 2022/12/7 10:33
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            return hasPathSum(root.left, targetSum);
        }
        if (root.right != null) {
            return hasPathSum(root.right, targetSum);
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node3 = new TreeNode(-3);

        node1.left = node2;
        node1.right = node3;

        boolean b = new Solution().hasPathSum(node1, -1);
        System.out.println(b);
    }
}
