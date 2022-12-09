package com.bobo.leetcode654;

import com.bobo.leetcode102.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode654 最大二叉树
 * @Date 2022/12/2 10:12
 */
public class Solution {


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int  i = 10/0;
        return buildTree(nums, 0, nums.length-1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int best = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[best]) {
                best = i;
            }
        }
        TreeNode root = new TreeNode(nums[best]);
        root.left = buildTree(nums, left, best - 1);
        root.right = buildTree(nums, best + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        new Solution().constructMaximumBinaryTree(nums);
    }
}
