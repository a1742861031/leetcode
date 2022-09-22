package com.bobo.leetcode491;

import java.util.*;

/**
 * @author by bobo
 * @Description leetcode 491 递增子序列
 * @Date 2022/9/21 09:16
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private Stack<Integer> path = new Stack<>();
    private Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return ans;
    }

    public void backTracking(int[] nums, int begin) {
        if (path.size() > 1) {
            List<Integer> current = new ArrayList<>(path);
            ans.add(current);
        }
        //注意递归 回溯时这里的set会保存，所以可以判断当层是否使用了这个数
        Set<Integer> set = new HashSet<>();
        for (int i = begin; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            //如果是第一个元素，直接写入
            if (path.size() == 0) {
                path.add(nums[i]);
                set.add(nums[i]);
                //判断是否递增
            } else if (nums[i] >= path.peek()) {
                path.add(nums[i]);
                set.add(nums[i]);
            } else {
                continue;
            }
            backTracking(nums, i + 1);
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 7, 7};
        List<List<Integer>> subsequences = new Solution().findSubsequences(nums);
        System.out.println(subsequences);
    }
}
