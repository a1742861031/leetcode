package com.bobo.leetcode78;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author by bobo
 * @Description 78-子集
 * @Date 2022/9/19 10:26
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        backTracking(nums, ans, path, 0);
        return ans;
    }

    public void backTracking(int[] nums, List<List<Integer>> ans, Stack<Integer> path, int begin) {
        List<Integer> cur = new ArrayList<>(path);
        ans.add(cur);
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums,ans,path,i+1);
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Solution().subsets(nums));
    }
}
