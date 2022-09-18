package com.bobo.leetcode216;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author by bobo
 * @Description leetcode 216题 组合综合
 * @Date 2022/9/17 19:27
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Stack<Integer> path = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, path, k, n, 1, 0);
        return ans;
    }

    public void backTracking(List<List<Integer>> ans, Stack<Integer> path, int k, int n, int begin, int sum) {
        if (path.size() == k && sum == n) {
            List<Integer> cur = new ArrayList<>(path);
            ans.add(cur);
            return;
        }
        //剪枝
        if (sum >= n) {
            return;
        }
        //通过begin 限定该路径的最小的数字
        for (int i = begin; i < 10; i++) {
            path.push(i);
            sum += i;
            backTracking(ans, path, k, n, i + 1, sum);
            path.pop();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> answer = new Solution().combinationSum3(2, 18);
        System.out.println(answer);
    }
}
