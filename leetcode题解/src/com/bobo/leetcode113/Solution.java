package com.bobo.leetcode113;

import com.bobo.leetcode102.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description 路径总和2
 * @Date 2022/12/7 11:13
 */
public class Solution {
    List<List<Integer>> ans;
    List<Integer> cur;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        cur = new ArrayList<>();
        if (root == null) {
            return null;
        }
        cur.add(root.val);
        dfs(root, targetSum - root.val);
        System.out.println(ans);
        return ans;
    }

    public void dfs(TreeNode node, int targetSum) {
        if (node.left == null && node.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            targetSum -= node.left.val;
            cur.add(node.left.val);
            dfs(node.left, targetSum);
            targetSum += node.left.val;
            cur.remove(cur.size() - 1);
        }
        if (node.right != null) {
            targetSum -= node.right.val;
            cur.add(node.right.val);
            dfs(node.right, targetSum);
            targetSum += node.right.val;
            cur.remove(cur.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        new Solution().pathSum(node1,20);
    }
}
