package com.bobo.leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author by bobo
 * @Description leetcode 39 组合总和
 * @Date 2022/9/16 10:21
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        Arrays.sort(candidates);
        backTracking(candidates, answer, target, path, 0);

        return answer;
    }

    public void backTracking(int[] candidates, List<List<Integer>> answer, int target, Stack<Integer> path, int begin) {
        //递归终止条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> cur = new ArrayList<>(path);
            answer.add(cur);
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.push(candidates[i]);
            backTracking(candidates, answer, target-candidates[i], path, i);
            path.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2};
        List<List<Integer>> lists = solution.combinationSum(arr, 1);
        System.out.println(lists);
    }
}
