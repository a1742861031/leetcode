package com.bobo.leetcode131;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author by bobo
 * @Description 分割回文串
 * @Date 2022/9/18 11:48
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backTracking(s, ans, stack, 0);
        return ans;
    }

    public void backTracking(String s, List<List<String>> ans, Stack<String> stack, int begin) {
        if (begin >= s.length()) {
            List<String> cur = new ArrayList<>(stack);
            ans.add(cur);
            return;
        }
        for (int i = begin; i < s.length(); i++) {
            String substring = s.substring(begin, i + 1);
            if (judgePalindrome(substring)) {
                stack.push(substring);
            } else {
                continue;
            }
            backTracking(s, ans, stack, i + 1);
            stack.pop();
        }
    }

    public boolean judgePalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution().partition(s));
    }
}
