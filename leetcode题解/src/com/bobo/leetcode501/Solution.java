package com.bobo.leetcode501;

import com.bobo.leetcode102.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description 501. 二叉搜索树中的众数
 * @Date 2022/12/5 09:46
 */
/*
二叉搜素树的中序遍历是有顺序的
 */
public class Solution {
    List<Integer> ans;
    int maxCount;
    int count;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        ans = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        middleDfs(root);
        System.out.println(ans);
        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }

    public void middleDfs(TreeNode node) {
        if (node == null) {
            return;
        }
        middleDfs(node.left);
        if (pre == null || node.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            ans.clear();
            maxCount = count;
            ans.add(node.val);
        } else if (count == maxCount) {
            ans.add(node.val);
        }
        pre = node;
        middleDfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;
        new Solution().findMode(node1);
    }
}
