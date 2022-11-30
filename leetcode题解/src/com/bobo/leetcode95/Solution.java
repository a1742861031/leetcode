package com.bobo.leetcode95;

import com.bobo.leetcode102.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description leetcode95 不同的二叉搜索树
 * @Date 2022/11/24 09:08
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return helper(1, n);

    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = leftTree;
                    currTree.right = rightTree;
                    ans.add(currTree);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
