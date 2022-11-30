package com.bobo.leetcode701;

import com.bobo.leetcode102.TreeNode;

/**
 * @author by bobo
 * @Description leetcode701 二叉搜索树的插入操作
 * @Date 2022/11/24 09:45
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    public void insert(TreeNode root, int val) {
        if (root.val > val && root.left == null) {
            root.left = new TreeNode(val);
            return;
        } else if (root.val < val && root.right == null) {
            root.right = new TreeNode(val);
            return;
        }
        if (root.val > val) {
            insertIntoBST(root.left, val);
        } else {
            insertIntoBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        new Solution().insertIntoBST(treeNode1, 5);
    }
}
