package com.bobo.leetcode77;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author by bobo
 * @Description leetcode77 组合
 * @Date 2022/9/15 15:27
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        backTracking(result, path, 1, n, k);
        return result;
    }

    public void backTracking(List<List<Integer>> array, Stack<Integer> path, int startIndex, int endIndex, int k) {
        //终止条件
        if (path.size() == k) {
            List<Integer> cur = new ArrayList<>(path);
            array.add(cur);
            return;
        }
        for (int i = startIndex; i <= endIndex - (k - path.size()) + 1; i++) {
            //处理节点
            path.push(i);
            //递归
            backTracking(array, path, i + 1, endIndex, k);
            //回溯
            path.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution().combine(4, 2);
        System.out.println(combine);
    }

}
