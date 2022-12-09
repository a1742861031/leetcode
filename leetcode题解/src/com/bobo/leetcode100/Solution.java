package com.bobo.leetcode100;

import com.bobo.LeetCode21.ListNode;
import com.bobo.leetcode102.TreeNode;

/**
 * @author by bobo
 * @Description leetcode 100 相同的树
 * @Date 2022/12/1 08:29
 */
public class Solution {
    private boolean equalResult = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p,q);
        return equalResult;
    }

    public void dfs(TreeNode p, TreeNode q) {
        if (equalResult) {
            if (p != null && q == null || p == null && q != null) {
                equalResult = false;
                return;
            }
            if (p != null) {
                if (p.val != q.val) {
                    equalResult = false;
                    return;
                }
                dfs(p.left, q.left);
                dfs(p.right, q.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        TreeNode node11 = new TreeNode(1);
        TreeNode node31 = new TreeNode(3);
        node11.right = node31;
        boolean sameTree = new Solution().isSameTree(node1, node11);
        System.out.println(sameTree);
    }
}
