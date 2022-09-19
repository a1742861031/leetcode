package com.bobo.leetcode93;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author by bobo
 * @Description 93-复原IP地址
 * @Date 2022/9/19 09:24
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        Stack<String> path = new Stack<>();
        backTracking(s, ans, path, 0);
        return ans;
    }

    public void backTracking(String s, List<String> ans, Stack<String> path, int begin) {
        if (path.size() == 4 && begin == s.length()) {
            StringBuilder current = new StringBuilder();
            for (String item : path) {
                current.append(item).append(".");
            }
            current.deleteCharAt(current.length() - 1);
            ans.add(current.toString());
        }
        for (int i = begin; i < s.length(); i++) {

            String str = s.substring(begin, i + 1);
            if (str.length() <= 3) {
                if (str.length() > 1 && str.charAt(0) == '0') {
                    continue;
                }
                int parseInt = Integer.parseInt(str);
                if (parseInt >= 0 && parseInt <= 255) {
                    path.push(str);
                } else {
                    continue;
                }
            } else {
                continue;
            }
            backTracking(s, ans, path, i + 1);
            path.pop();
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("101023"));
    }
}
