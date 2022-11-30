package com.bobo.leetcode108;

import com.bobo.leetcode102.TreeNode;

/**
 * @author by bobo
 * @Description leetcode  将有序数组转换为二叉搜索树
 * @Date 2022/11/28 10:51
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left < right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = helper(nums, left, middle - 1);
        root.right = helper(nums, right, middle + 1);
        return root;
    }
}
