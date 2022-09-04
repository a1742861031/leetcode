package com.bobo.leetcode392;

/**
 * @author by bobo
 * @Description LeetCode392题 判断子序列
 * @Date 2022/7/5 8:51 AM
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        //t字符串的下标
        int tIndex = 0;
        if (s.length() > t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (tIndex >= t.length()) {
                return false;
            }
            while (t.charAt(tIndex) != s.charAt(i)) {
                tIndex++;
            }
            tIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaaaaa";
        String t = "bbaaaa";
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence(s, t));
    }
}
