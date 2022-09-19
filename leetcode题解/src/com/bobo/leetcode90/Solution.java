package com.bobo.leetcode90;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author by bobo
 * @Description leetcode90-子集2
 * @Date 2022/9/19 10:37
 */
public class Solution {
    Stack<Integer> stack = new Stack<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, 0, used);
        return ans;
    }

    public void backTracking(int[] nums, int begin, boolean[] used) {
        ans.add(new ArrayList<>(stack));
        if (begin > nums.length) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            //判读的条件是什么?
            if (i >= 1 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            } else {
                stack.add(nums[i]);
                used[i] = true;
            }
            backTracking(nums, i + 1, used);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,2};
        List<List<Integer>> lists = solution.subsetsWithDup(arr);
        System.out.println(lists);
    }
}
