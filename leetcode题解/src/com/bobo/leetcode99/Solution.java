package com.bobo.leetcode99;

import com.bobo.leetcode102.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description 恢复二叉搜索树
 * @Date 2022/11/28 10:18
 */
/*
解题思路 二叉搜索树按照中序遍历的顺序是递增的
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        middleDfs(list, root);
        TreeNode x = null;
        TreeNode y = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                if (x == null) {
                    x = list.get(i);
                }
                y = list.get(i + 1);
            }
        }
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void middleDfs(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }
        middleDfs(list, node.left);
        list.add(node);
        middleDfs(list, node.right);
    }

    public static void main(String[] args) {

    }
}
