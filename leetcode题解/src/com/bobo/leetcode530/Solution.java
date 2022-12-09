package com.bobo.leetcode530;

import com.bobo.leetcode102.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by bobo
 * @Description leetcode530 二叉搜索树的最小高度差
 * @Date 2022/12/3 11:55
 */
public class Solution {
    int min = Integer.MAX_VALUE;
    List<Integer> list;

    public int getMinimumDifference(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < sorted.size() - 1; i++) {
            int sub = sorted.get(i + 1) - sorted.get(i);
            min = Math.min(sub, min);
        }
        return min;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(new Solution().getMinimumDifference(node1));
    }
}
