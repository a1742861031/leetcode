package com.bobo.leetcode404;

import com.bobo.LeetCode21.ListNode;
import com.bobo.leetcode102.TreeNode;

/**
 * @author by bobo
 * @Description leetcode404 左叶子之和
 * @Date 2022/11/23 10:12
 */
public class Solution {
    int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        preDfs(root,false);
        return sum;
    }

    public void preDfs(TreeNode root,boolean flag) {
            if (root != null) {
            if (root.left == null&&root.right==null) {
                if(flag){
                    sum += root.val;
                }
            }else {
                preDfs(root.left,true);
                preDfs(root.right,false);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left  = treeNode4;
        treeNode3.right = treeNode5;
        int i = new Solution().sumOfLeftLeaves(treeNode1);
        System.out.println(i);
    }
}
