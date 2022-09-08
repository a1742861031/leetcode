package com.bobo.leetcode617;


/**
 * @author by bobo
 * @Description 617. 合并二叉树
 * @Date 2022/9/8 10:30 AM
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //当树1为空或者树2为空时，直接返回
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        return dfs(root1, root2);
    }

    public TreeNode dfs(TreeNode root1, TreeNode root2) {
        //当树1 或树2 当前节点为空时，为递归终止条件
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        //合并后当前节点值
        root1.val = root1.val + root2.val;
        //递归当前节点的左节点
        root1.left = dfs(root1.left, root2.left);
        //递归当前节点的右节点
        root1.right = dfs(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {

    }
}