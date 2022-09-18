package com.bobo.leetcode46;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author by bobo
 * @Description leetcode 46 全排列
 * @Date 2022/9/16 12:33
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        backTracking(nums,ans,stack);
        return ans;
    }
    public void backTracking(int[] nums,List<List<Integer>> ans, Stack<Integer> path){
        if(path.size()==nums.length){
            List<Integer> list = new ArrayList<>(path);
            ans.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])){
                continue;
            }
            path.push(nums[i]);
            backTracking(nums,ans,path);
            path.pop();
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> permute = new Solution().permute(arr);
        System.out.println(permute);
    }
}
