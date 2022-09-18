package com.bobo.leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author by bobo
 * @Description leetcode47-全排列
 * @Date 2022/9/17 12:29
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracking(nums, ans, stack, used);
        return ans;
    }

    /**
     * @param nums 原数组
     * @param ans  结果
     * @param path 当前分支路径
     * @param used 当前值是否入path
     */
    public void backTracking(int[] nums, List<List<Integer>> ans, Stack<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            List<Integer> cur = new ArrayList<>(path);
            ans.add(cur);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            //剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracking(nums, ans, path, used);
            path.pop();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        List<List<Integer>> permute = new Solution().permuteUnique(arr);
        System.out.println(permute);
    }
}
